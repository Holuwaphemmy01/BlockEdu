package com.blockedu.BlockEdu.controller.generate;

import com.blockedu.BlockEdu.data.dtos.request.StudentGenerateUrlRequest;
import com.blockedu.BlockEdu.service.student.generate.GenerateUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class GenerateUrlController {

    @Autowired
    private GenerateUrlService generateUrlService;


    @GetMapping(name = "/generate_url")
    public ResponseEntity<?> generateUrl(@RequestBody StudentGenerateUrlRequest request) {
        return ResponseEntity.ok(generateUrlService.generateUrl(request));
    }

}
