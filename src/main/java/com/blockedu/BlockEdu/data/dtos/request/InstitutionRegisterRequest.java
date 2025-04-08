package com.blockedu.BlockEdu.data.dtos.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class InstitutionRegisterRequest {
    @NotB
    private String name;
    private String motto;
    private String address;
    private String state;
    private String city;
    private String Admin;
    private String officialMail;
    private String officialPhone;
    private String institutionType;
    private String email;
    private String password;
}
