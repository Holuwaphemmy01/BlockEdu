package com.blockedu.BlockEdu.data.dtos.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter

public class InstitutionLoginResponse {
    private String role;
    private String token;
    private String name;
    private String motto;
    private String admin;
    private String officialMail;
    private UUID id;
}
