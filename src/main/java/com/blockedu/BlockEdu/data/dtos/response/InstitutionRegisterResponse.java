package com.blockedu.BlockEdu.data.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitutionRegisterResponse {
    private String name;
    private String motto;
    private String address;
    private String state;
    private String city;
    private String Admin;
    private String officialMail;
    private String officialPhone;
    private String institutionType;
}
