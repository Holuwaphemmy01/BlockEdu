package com.blockedu.BlockEdu.service.institution.register;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionRegisterRequest;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionRegisterResponse;
import com.blockedu.BlockEdu.data.models.Institution;
import com.blockedu.BlockEdu.mapper.InstitutionRegisterRequestMap;
import com.blockedu.BlockEdu.repository.InstitutionRepository;
import io.jsonwebtoken.security.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class InstitutionRegisterServiceImpl implements InstitutionRegisterService  {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private InstitutionRegisterRequestMap institutionRegisterRequestMap;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public InstitutionRegisterResponse register(InstitutionRegisterRequest request) {


        Optional<Institution> institution = institutionRepository.findByEmail(request.getEmail());
        if(institution.isPresent()) throw new RuntimeException("Email already exists");
        Institution mapResponse = institutionRegisterRequestMap.toEntity(request);
        mapResponse.setId(UUID.randomUUID());
        mapResponse.setPassword(passwordEncoder.encode(mapResponse.getPassword()));
        Institution dbResponse = institutionRepository.save(mapResponse);
        return  institutionRegisterRequestMap.toResponse(dbResponse);
    }
}
