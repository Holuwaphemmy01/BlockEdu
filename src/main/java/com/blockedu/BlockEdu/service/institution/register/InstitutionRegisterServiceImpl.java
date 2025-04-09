package com.blockedu.BlockEdu.service.institution.register;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionRegisterRequest;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionRegisterResponse;
import com.blockedu.BlockEdu.data.models.Institution;
import com.blockedu.BlockEdu.exception.DuplicateInstitutionException;
import com.blockedu.BlockEdu.mapper.InstitutionRegisterRequestMap;
import com.blockedu.BlockEdu.repository.InstitutionRepository;
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

        checkDuplicateInDataBase(request);

        Institution mapResponse = institutionRegisterRequestMap.toEntity(request);

        mapResponse.setId(UUID.randomUUID());

        mapResponse.setPassword(passwordEncoder.encode(mapResponse.getPassword()));

        Institution dbResponse = institutionRepository.save(mapResponse);

        return  institutionRegisterRequestMap.toResponse(dbResponse);
    }


    private void checkDuplicateInDataBase(InstitutionRegisterRequest request) {
        Optional<Institution> institution1 = institutionRepository.findByName(request.getName());
        if (institution1.isPresent()) throw new DuplicateInstitutionException("Name already exists");
        Optional<Institution> institution = institutionRepository.findByOfficialMail(request.getOfficialMail());
        if (institution.isPresent()) throw new DuplicateInstitutionException("Email already exists");
        Optional<Institution> institution2 = institutionRepository.findByOfficialPhone(request.getOfficialPhone());
        if (institution2.isPresent()) throw new DuplicateInstitutionException("Phone number already exists");
    }
}
