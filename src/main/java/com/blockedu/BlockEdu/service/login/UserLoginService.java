package com.blockedu.BlockEdu.service.login;

import com.blockedu.BlockEdu.data.dtos.request.UserLoginRequest;
import com.blockedu.BlockEdu.data.dtos.response.UserLoginResponse;

public interface UserLoginService {

    UserLoginResponse login (UserLoginRequest userLoginRequest);
}
