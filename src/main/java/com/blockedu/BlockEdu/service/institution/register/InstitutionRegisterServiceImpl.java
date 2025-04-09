package com.blockedu.BlockEdu.service.institution.register;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionRegisterRequest;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionRegisterResponse;
import com.blockedu.BlockEdu.data.models.Institution;
import com.blockedu.BlockEdu.mapper.InstitutionRegisterRequestMap;
import com.blockedu.BlockEdu.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InstitutionRegisterServiceImpl implements InstitutionRegisterService  {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private InstitutionRegisterRequestMap institutionRegisterRequestMap;



    @Override
    public InstitutionRegisterResponse register(InstitutionRegisterRequest request) {

        Institution mapResponse = institutionRegisterRequestMap.toEntity(request);
        mapResponse.setId(UUID.randomUUID());
        Institution dbResponse = institutionRepository.save(mapResponse);
        if(dbResponse == null) throw new RuntimeException("Failed to save institution");
        return  institutionRegisterRequestMap.toResponse(dbResponse);

    }
}
