package com.blockedu.BlockEdu.controller.register;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionRegisterRequest;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionRegisterResponse;
import com.blockedu.BlockEdu.service.institution.register.InstitutionRegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/institution")
public class InstitutionRegistrationController {

    @Autowired
    private InstitutionRegisterService institutionRegisterService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody InstitutionRegisterRequest request) {

        InstitutionRegisterResponse response = institutionRegisterService.register(request);
        return ResponseEntity.status(201).body(response);
    }

}
