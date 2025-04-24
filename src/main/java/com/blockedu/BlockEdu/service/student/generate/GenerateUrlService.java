package com.blockedu.BlockEdu.service.student.generate;

import com.blockedu.BlockEdu.data.dtos.request.StudentGenerateUrlRequest;
import com.blockedu.BlockEdu.data.models.Student;
import com.blockedu.BlockEdu.data.models.StudentUrlData;
import com.blockedu.BlockEdu.repository.StudentRepository;
import com.blockedu.BlockEdu.repository.StudentUrlDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.UUID;

@Service
public class GenerateUrlService implements GenerateUrl{

    @Autowired
    private StudentUrlDataRepository urlDataRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Value("${blob.download.url}")
    private String url;


    @Override
    public String generateUrl(StudentGenerateUrlRequest request) {

        StudentUrlData urlData = new StudentUrlData();

        Optional<Student> student = studentRepository.findByStudentId(request.getStudentId());

        if (student.isPresent()) {
            if(!student.get().getFirstName().equalsIgnoreCase(request.getFirstName()) && student.get().getLastName().equalsIgnoreCase(request.getLastName()))
                throw new IllegalArgumentException("Student not found");
        }
        else throw new IllegalArgumentException("Student not found");

        String blobId = student.get().getCredentialsUploadId();


        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url + blobId))
                    .GET()
                    .build();

            HttpResponse<byte[]> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());

            if (response.statusCode() == 200) {
                urlData.setContent(response.body());
            } else {
                throw new RuntimeException("Failed to fetch PDF. Status code: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error while fetching PDF blob: " + e.getMessage(), e);
        }
        urlData.setId(UUID.randomUUID().toString());
        urlData.setFirstName(student.get().getFirstName());
        urlData.setLastName(student.get().getLastName());
        urlData.setEmail(student.get().getEmail());
        urlData.setInstitutionName(student.get().getInstitution().getName());
        urlData.setBlockChainAddress("0xtwt7owk222sj7gs4bs200enns00r555suw529msb");
        urlData.setInstitutionMotto(student.get().getInstitution().getMotto());
        urlDataRepository.save(urlData);

        return "/studentUrlData/" + urlData.getId();
    }
}
