package com.blockedu.BlockEdu.service.institution.login;


import com.blockedu.BlockEdu.data.dtos.request.InstitutionLoginRequest;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionLoginResponse;
import com.blockedu.BlockEdu.data.models.Institution;
import com.blockedu.BlockEdu.mapper.InstitutionLoginMap;
import com.blockedu.BlockEdu.repository.InstitutionRepository;
import com.blockedu.BlockEdu.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstitutionLoginServiceImpl implements InstitutionLoginService {

        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        private  JwtTokenProvider jwtTokenProvider;

        @Autowired
        private InstitutionLoginMap institutionLoginMap;

        @Autowired
        private InstitutionRepository institutionRepository;


    @Override
    public InstitutionLoginResponse login(InstitutionLoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getOfficialMail(), request.getPassword()));
        String token = jwtTokenProvider.generateToken(authentication);

        String role = authentication.getAuthorities().iterator().next().getAuthority();


        Institution institution = institutionRepository.findByOfficialMail(request.getOfficialMail())
                .orElseThrow(() -> new RuntimeException("Institution not found"));

        InstitutionLoginResponse institutionLoginResponse = institutionLoginMap.toResponse(institution);
        institutionLoginResponse.setToken(token);
        institutionLoginResponse.setRole(role);

        return institutionLoginResponse;
    }
}
