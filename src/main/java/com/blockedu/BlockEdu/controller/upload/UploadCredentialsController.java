package com.blockedu.BlockEdu.controller.upload;

import com.blockedu.BlockEdu.data.dtos.request.UploadCredentialRequest;
import com.blockedu.BlockEdu.data.dtos.response.UploadCredentialResponse;
import com.blockedu.BlockEdu.service.institution.upload_credentials.UploadCredentialsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/institution")
public class UploadCredentialsController {

    @Autowired
    private UploadCredentialsService uploadCredentialsService;

    @Autowired
    private ObjectMapper objectMapper; // inject ObjectMapper

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadCredentials(
            @RequestPart("file") MultipartFile file,
            @RequestPart("data") String requestJson
    ) throws IOException, InterruptedException {

        UploadCredentialRequest request = objectMapper.readValue(requestJson, UploadCredentialRequest.class);

        request.setCertificate(file);

        UploadCredentialResponse response = uploadCredentialsService.upload(request);
        return ResponseEntity.ok(response);
    }
}
