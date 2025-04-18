package com.blockedu.BlockEdu.controller.upload;

import com.blockedu.BlockEdu.data.dtos.request.UploadCredentialRequest;
import com.blockedu.BlockEdu.data.dtos.response.UploadCredentialResponse;
import com.blockedu.BlockEdu.exception.UploadFailedException;
import com.blockedu.BlockEdu.service.institution.upload_credentials.UploadCredentialsService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/institution")
public class UploadCredentialsController {

    @Autowired
    private UploadCredentialsService uploadCredentialsService;


    @SneakyThrows
    @PostMapping("/upload")
    public ResponseEntity<?> uploadCredentials(@RequestBody UploadCredentialRequest request) {
            UploadCredentialResponse response = uploadCredentialsService.upload(request);
            return ResponseEntity.ok(response);
    }
}
