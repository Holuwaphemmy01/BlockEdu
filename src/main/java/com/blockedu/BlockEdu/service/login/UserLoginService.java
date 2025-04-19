package com.blockedu.BlockEdu.service.login;

import com.blockedu.BlockEdu.data.dtos.request.UserLoginRequest;
import com.blockedu.BlockEdu.data.dtos.response.LoginResponse;

public interface UserLoginService {

    LoginResponse login (UserLoginRequest userLoginRequest);
}
