package com.blockedu.BlockEdu.controller.download;

import com.blockedu.BlockEdu.data.dtos.request.DownloadCredentialsRequest;
import com.blockedu.BlockEdu.service.student.download_credentials.DownloadCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class DownloadCredentialsController {

    @Autowired
    private DownloadCredentialsService downloadCredentialsService;


    @GetMapping("/download_credential")
    public ResponseEntity<?> downloadCredentials(@RequestBody DownloadCredentialsRequest request) {
        return ResponseEntity.ok(downloadCredentialsService.download(request));
    }
}
