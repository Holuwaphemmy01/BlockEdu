package com.blockedu.BlockEdu.controller.login;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionLoginRequest;
import com.blockedu.BlockEdu.service.institution.login.InstitutionLoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/institution")
public class InstitutionLoginController {

    @Autowired
    private InstitutionLoginService institutionLoginService;

    @GetMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody InstitutionLoginRequest loginRequest) {
        return ResponseEntity.ok(institutionLoginService.login(loginRequest));
    }

}
