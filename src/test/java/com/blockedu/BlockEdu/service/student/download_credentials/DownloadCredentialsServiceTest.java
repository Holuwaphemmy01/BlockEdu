package com.blockedu.BlockEdu.service.student.download_credentials;

import com.blockedu.BlockEdu.data.dtos.request.DownloadCredentialsRequest;
import com.blockedu.BlockEdu.data.dtos.request.InstitutionRegisterRequest;
import com.blockedu.BlockEdu.data.dtos.request.UploadCredentialRequest;
import com.blockedu.BlockEdu.data.dtos.response.DownloadCredentialsResponse;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionRegisterResponse;
import com.blockedu.BlockEdu.data.dtos.response.UploadCredentialResponse;
import com.blockedu.BlockEdu.service.institution.register.InstitutionRegisterService;
import com.blockedu.BlockEdu.service.institution.upload_credentials.UploadCredentialsService;
import org.hibernate.validator.internal.constraintvalidators.hv.UUIDValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class DownloadCredentialsServiceTest {


    @Autowired
    private DownloadCredentialsService downloadCredentialsService;
    @Autowired
    private InstitutionRegisterService institutionRegisterService;
    @Autowired
    private UploadCredentialsService uploadCredentialsService;
    @Autowired
    private UUIDValidator uUIDValidator;


    @Test
    public void testToRetrieveUploadCredentialsWithTheCorrectStudentIdentity() throws IOException, InterruptedException {


        //register institution
        InstitutionRegisterRequest institutionRequest = new InstitutionRegisterRequest();
        institutionRequest.setName("Semi-colon");
        institutionRequest.setMotto("Femi");
        institutionRequest.setAddress("Adelek street");
        institutionRequest.setState("Ogun");
        institutionRequest.setCity("Sagamu");
        institutionRequest.setAdmin("Esther");
        institutionRequest.setOfficialMail("Oluwafemi@gmail.com");
        institutionRequest.setOfficialPhone("09025540752");
        institutionRequest.setInstitutionType("Private");
        institutionRequest.setPassword("727727272");
        InstitutionRegisterResponse registerResponse = institutionRegisterService.register(institutionRequest);
        assertNotNull(registerResponse);
        assertEquals("Oluwafemi", registerResponse.getName());
        assertEquals("Femi", registerResponse.getMotto());
        assertEquals("Adelek street", registerResponse.getAddress());
        UUID institutionId = registerResponse.getInstitutionId();


        //upload student credentials

        UploadCredentialRequest credentialRequest = new UploadCredentialRequest();
        Path path = Path.of("src/main/resources/test.txt");
        String name = "file";
        String originalFileName = "test.txt";
        String contentType = "text/plain";
        byte[] content = Files.readAllBytes(path);
        MultipartFile multipartFile = new MockMultipartFile(name, originalFileName, contentType, content);

        credentialRequest.setInstitutionId(String.valueOf(institutionId));
        credentialRequest.setInstitutionName("Semi-colon");
        credentialRequest.setStudentMail("jacoboluwafemi72@gmail.com");
        credentialRequest.setFirstName("Oluwafemi");
        credentialRequest.setLastName("Jacob");
        credentialRequest.setCertificate(multipartFile);
        credentialRequest.setStudentId("12345");

        UploadCredentialResponse credentialResponse = uploadCredentialsService.upload(credentialRequest);
        assertNotNull(credentialResponse);

        //student retrieves credentials
        DownloadCredentialsRequest downloadRequest = new DownloadCredentialsRequest();
        downloadRequest.setStudentId("12345");
        downloadRequest.setFirstName("Oluwafemi");
        downloadRequest.setLastName("Jacob");

        DownloadCredentialsResponse downloadResponse = downloadCredentialsService.download(downloadRequest);
        assertEquals(downloadRequest.getStudentId(), downloadResponse.getStudentId());
        System.out.println("This is the download response "+downloadResponse.toString());

    }
  
}