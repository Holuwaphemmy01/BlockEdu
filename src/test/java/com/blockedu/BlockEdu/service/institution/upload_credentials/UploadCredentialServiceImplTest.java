package com.blockedu.BlockEdu.service.institution.upload_credentials;

import com.blockedu.BlockEdu.data.dtos.request.UploadCredentialRequest;
import com.blockedu.BlockEdu.data.dtos.response.UploadCredentialResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UploadCredentialServiceImplTest {

    @Autowired
    private UploadCredentialsService uploadCredentialsService;


    @Test
    public void testUploadCredentials() throws IOException {
        UploadCredentialRequest request = new UploadCredentialRequest();
        Path path = Path.of("web3.txt");
        String name = "file";
        String originalFileName = "web3.txt";
        String contentType = "text/plain";
        byte[] content = Files.readAllBytes(path);
        MultipartFile multipartFile = new MockMultipartFile(name, originalFileName, contentType, content);


        request.setInstitutionId("12345");
        request.setInstitutionName("Semi-colon");
        request.setStudentMail("femi@mail.com");
        request.setCertificate(multipartFile);

        UploadCredentialResponse response = uploadCredentialsService.upload(request);
        assertNotNull(response);
        System.out.println(response);


    }

}