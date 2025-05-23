package com.blockedu.BlockEdu.controller.download;

import com.blockedu.BlockEdu.data.dtos.request.DownloadCredentialsRequest;
import com.blockedu.BlockEdu.service.student.download_credentials.DownloadCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class DownloadCredentialsController {

    @Autowired
    private DownloadCredentialsService downloadCredentialsService;


    @CrossOrigin("*")
    @PostMapping("/download_credential")
    public ResponseEntity<?> downloadCredentials(@RequestBody DownloadCredentialsRequest request) {
        return ResponseEntity.ok(downloadCredentialsService.download(request));
    }
}
