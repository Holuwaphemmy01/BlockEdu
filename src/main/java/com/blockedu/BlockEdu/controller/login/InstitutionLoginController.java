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

//    @Autowired
//    private InstitutionLoginService institutionLoginService;

    @Autowired
    private UserLoginServiceImpl userLogin;

    @GetMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginRequest loginRequest) {
        return ResponseEntity.ok(userLogin.login(loginRequest));
    }

}
