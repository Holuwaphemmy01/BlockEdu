package com.blockedu.BlockEdu.service.student.change_password;

import com.blockedu.BlockEdu.data.dtos.request.ChangePasswordRequest;
import com.blockedu.BlockEdu.data.dtos.response.ChangePasswordResponse;

public interface ChangePasswordService {
    ChangePasswordResponse changePassword(ChangePasswordRequest request);

}
