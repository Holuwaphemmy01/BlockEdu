package com.blockedu.BlockEdu.service.student.download_credentials;

import com.blockedu.BlockEdu.data.dtos.request.DownloadCredentialsRequest;
import com.blockedu.BlockEdu.data.dtos.response.DownloadCredentialsResponse;
import com.blockedu.BlockEdu.data.models.Student;
import com.blockedu.BlockEdu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Service
public class DownloadCredentialsService implements DownloadCredentials {

    @Autowired
    private StudentRepository studentRepository;

    @Value("${blob.download.url}")
    private String url;

    @Override
    public DownloadCredentialsResponse download(DownloadCredentialsRequest request) {

        DownloadCredentialsResponse credentialsResponse = new DownloadCredentialsResponse();

        List<Student> allStudent = studentRepository.findAll();
        System.out.println("This all the student "+allStudent.toString());

        System.out.println("This is the student id"+ request.getStudentId());

        Optional<Student> student = studentRepository.findByStudentId(request.getStudentId());

        if (student.isPresent()) {
            System.out.println("This is the student details "+student.toString());
            if(student.get().getFirstName().equalsIgnoreCase(request.getFirstName())) System.out.println("firstName correct");
            if (student.get().getLastName().equalsIgnoreCase(request.getLastName())) System.out.println("lastName is correct");
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
                 credentialsResponse.setFile(response.body());
            } else {
                throw new RuntimeException("Failed to fetch PDF. Status code: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error while fetching PDF blob: " + e.getMessage(), e);
        }


        credentialsResponse.setInstitutionName(student.get().getInstitution().getName());
        credentialsResponse.setInstitutionMotto(student.get().getInstitution().getMotto());
        credentialsResponse.setStudentName(student.get().getStudentId());
        credentialsResponse.setBlockChainAddress("6262626262626262");

        return credentialsResponse;
    }
}
