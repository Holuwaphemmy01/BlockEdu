package com.blockedu.BlockEdu.service.institution.register;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionRegisterRequest;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionRegisterResponse;

public interface InstitutionRegisterService {
    InstitutionRegisterResponse register (InstitutionRegisterRequest request);
}
