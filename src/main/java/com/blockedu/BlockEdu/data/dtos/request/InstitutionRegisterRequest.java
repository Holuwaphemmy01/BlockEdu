package com.blockedu.BlockEdu.data.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitutionRegisterRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Motto is required")
    private String motto;
    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "Admin is required")
    private String admin;
    @NotBlank(message = "Official Mail is required")
    private String officialMail;
    @NotBlank(message = "Official Phone is required")
    private String officialPhone;
    @NotBlank(message = "Institution Type is required")
    private String institutionType;
    @NotBlank(message = "Email is required")
    @Email
    private String email;
    @NotBlank(message = "Password is required")
    private String password;


}
