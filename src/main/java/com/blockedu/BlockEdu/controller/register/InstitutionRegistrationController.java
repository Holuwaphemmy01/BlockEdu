package com.blockedu.BlockEdu.controller.register;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionRegisterRequest;
import com.blockedu.BlockEdu.service.institution.register.InstitutionRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/institution")
public class InstitutionRegistrationController {

    @Autowired
    private InstitutionRegisterService institutionRegisterService;

    @RequestMapping("/register")
    public ResponseEntity<?> register(@RequestBody InstitutionRegisterRequest request) {
        try{
             return ResponseEntity.ok(institutionRegisterService.register(request));
        } catch(RuntimeException runtimeException) {
            return ResponseEntity.badRequest().body(runtimeException.getMessage());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
