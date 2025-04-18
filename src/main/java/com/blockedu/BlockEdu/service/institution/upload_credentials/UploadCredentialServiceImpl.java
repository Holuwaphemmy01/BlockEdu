package com.blockedu.BlockEdu.service.institution.upload_credentials;

import com.blockedu.BlockEdu.data.dtos.request.UploadCredentialRequest;
import com.blockedu.BlockEdu.data.dtos.response.UploadCredentialResponse;
import com.blockedu.BlockEdu.data.models.Student;
import com.blockedu.BlockEdu.repository.InstitutionRepository;
import com.blockedu.BlockEdu.repository.StudentRepository;
import com.blockedu.BlockEdu.service.email_service.EmailService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;


@Service
public class UploadCredentialServiceImpl implements UploadCredentialsService{

    @Autowired
    private InstitutionRepository InstitutionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmailService emailService;

    private final ObjectMapper mapper = new ObjectMapper();

    @Value("${blob.upload.url}")
    private String url;

    @Value("${blob.upload.epochs}")
    private int epochs;



    @Override
    public UploadCredentialResponse upload(UploadCredentialRequest uploadCredentialRequest) throws IOException, InterruptedException {

        UploadCredentialResponse uploadCredentialResponse = new UploadCredentialResponse();


        Optional<Student> mailExist = studentRepository.findByEmail(uploadCredentialRequest.getStudentMail());
        if (mailExist.isPresent()) throw new IllegalArgumentException("email already exists");

        HttpClient client = HttpClient.newHttpClient();


        MultipartFile certificate = uploadCredentialRequest.getCertificate();
        byte[] data = certificate.getBytes();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .PUT(HttpRequest.BodyPublishers.ofByteArray(data))
                .header("Content-Type", "application/octet-stream")
                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to upload credentials " + response.statusCode());
        }


        String jsonResponse = response.body();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(jsonResponse);

        String blobId = rootNode.path("alreadyCertified").path("blobId").asText();
        uploadCredentialResponse.setCredentialsUploadId(blobId);


        String code = emailService.sendVerificationCode(uploadCredentialRequest.getStudentMail(), uploadCredentialRequest.getFirstName(), uploadCredentialRequest.getLastName());

        System.out.println(code);



        return uploadCredentialResponse;
    }
}
