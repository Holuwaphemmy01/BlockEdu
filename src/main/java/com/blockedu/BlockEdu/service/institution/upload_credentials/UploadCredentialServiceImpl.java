package com.blockedu.BlockEdu.service.institution.upload_credentials;

import com.blockedu.BlockEdu.data.dtos.request.UploadCredentialRequest;
import com.blockedu.BlockEdu.data.dtos.response.UploadCredentialResponse;
import com.blockedu.BlockEdu.repository.InstitutionRepository;
import com.blockedu.BlockEdu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class UploadCredentialServiceImpl implements UploadCredentialsService{

    @Autowired
    private InstitutionRepository InstitutionRepository;

    @Autowired
    private StudentRepository StudentRepository;

    @Value("${blob.upload.url}")
    private String url;

    @Value("${blob.upload.epochs}")
    private int epochs;

    @Override
    public UploadCredentialResponse upload(UploadCredentialRequest uploadCredentialRequest) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .PUT(HttpRequest.BodyPublishers.ofByteArray(uploadCredentialRequest.getTranscript().getBytes()))
                .header("Content-Type", "application/octet-stream")
                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to upload credentials " + response.statusCode());
        }










        return null;
    }
}
