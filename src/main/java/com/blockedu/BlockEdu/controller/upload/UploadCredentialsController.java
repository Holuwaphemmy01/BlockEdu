package com.blockedu.BlockEdu.controller.upload;

import com.blockedu.BlockEdu.data.dtos.request.UploadCredentialRequest;
import com.blockedu.BlockEdu.data.dtos.response.UploadCredentialResponse;
import com.blockedu.BlockEdu.service.institution.upload_credentials.UploadCredentialsService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/institution")
public class UploadCredentialsController {

    @Autowired
    private UploadCredentialsService uploadCredentialsService;


    @SneakyThrows
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadCredentials(@RequestPart("file") MultipartFile file,
                                               @RequestPart("data") UploadCredentialRequest request ) {

            request.setCertificate(file);
            UploadCredentialResponse response = uploadCredentialsService.upload(request);
            return ResponseEntity.ok("file recieved successfuuly");
    }
}
