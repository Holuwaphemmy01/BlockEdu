package com.blockedu.BlockEdu.data.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitutionLoginRequest {
    @Email
    @NotBlank
    private String officialMail;
    @NotBlank
    private String password;
}
