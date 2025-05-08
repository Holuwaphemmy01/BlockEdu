package com.blockedu.BlockEdu.controller.change_password;

import com.blockedu.BlockEdu.data.dtos.request.ChangePasswordRequest;
import com.blockedu.BlockEdu.data.dtos.response.ChangePasswordResponse;
import com.blockedu.BlockEdu.service.student.change_password.ChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class ChangePasswordController {

    @Autowired
    private ChangePasswordService changePasswordService;


    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request){
        ChangePasswordResponse response = changePasswordService.changePassword(request);
        return ResponseEntity.ok(response);
    }
}
