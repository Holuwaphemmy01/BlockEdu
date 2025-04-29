package com.blockedu.BlockEdu.controller.login;

import com.blockedu.BlockEdu.data.dtos.request.UserLoginRequest;
//import com.blockedu.BlockEdu.service.institution.login.InstitutionLoginService;
import com.blockedu.BlockEdu.service.login.UserLoginServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class InstitutionLoginController {



    @Autowired
    private UserLoginServiceImpl userLogin;

    @CrossOrigin("*")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest loginRequest) {
        System.out.println("request"+ loginRequest.toString());
        return ResponseEntity.ok(userLogin.login(loginRequest));
    }

}
