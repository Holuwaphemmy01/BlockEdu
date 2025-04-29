package com.blockedu.BlockEdu.service.access_url;

import com.blockedu.BlockEdu.data.dtos.response.AccessUrlResponse;
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
import java.util.Arrays;
import java.util.Optional;

@Service
public class AccessUrlServiceImpl implements AccessUrlService {

    @Autowired
    private StudentUrlDataRepository studentUrlDataRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Value("${blob.download.url}")
    private String blobUrl;


    @Override
    public AccessUrlResponse accessUrl(String url) {


        Optional<StudentUrlData> studentUrlData = studentUrlDataRepository.findById(url);

        if (studentUrlData.isEmpty()) throw new IllegalArgumentException("URL not found");



        Optional<Student> student = studentRepository.findByStudentId(studentUrlData.get().getStudentId());

        if (student.isPresent()) {
            if(!student.get().getFirstName().equalsIgnoreCase(studentUrlData.get().getFirstName()) && student.get().getLastName().equalsIgnoreCase(studentUrlData.get().getLastName()))
                throw new IllegalArgumentException("Student not found");
        }
        else throw new IllegalArgumentException("Student not found");

        String blobId = student.get().getCredentialsUploadId();


        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(blobUrl + blobId))
                    .GET()
                    .build();

            HttpResponse<byte[]> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());

            System.out.println("This is the blobId "+ student.get().getCredentialsUploadId());
            System.out.println("This is status code: " + response.statusCode());

            if (response.statusCode() == 200) {
                studentUrlData.get().setContent(response.body());
                System.out.println(Arrays.toString(studentUrlData.get().getContent()));
            } else {
                throw new RuntimeException("Failed to fetch PDF. Status code: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error while fetching PDF blob: " + e.getMessage(), e);
        }




        AccessUrlResponse accessUrlResponse = new AccessUrlResponse();

        accessUrlResponse.setFirstName(studentUrlData.get().getFirstName());
        accessUrlResponse.setLastName(studentUrlData.get().getLastName());
        accessUrlResponse.setInstitutionName(studentUrlData.get().getInstitutionName());
        accessUrlResponse.setInstitutionMotto(studentUrlData.get().getInstitutionMotto());
        accessUrlResponse.setBlockChainAddress(studentUrlData.get().getBlockChainAddress());
        accessUrlResponse.setContent(studentUrlData.get().getContent());

       // accessUrlResponse.setCredentialsDate();


        return accessUrlResponse;
    }
}
