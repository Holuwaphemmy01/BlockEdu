package com.blockedu.BlockEdu.service.institution.login;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionLoginRequest;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionLoginResponse;

public interface InstitutionLoginService {
    InstitutionLoginResponse login(InstitutionLoginRequest request);
}
