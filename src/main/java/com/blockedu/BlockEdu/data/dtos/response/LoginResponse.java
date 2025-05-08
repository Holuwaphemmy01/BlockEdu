package com.blockedu.BlockEdu.data.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class LoginResponse {


    private String role;
    private String token;
    private String email;
    private String studentId;
    private String firstName;
    private String lastName;
    private String name;
    private String motto;
    private String admin;
    private String officialMail;
    private UUID id;
    private boolean studentFirstLogin;

}
