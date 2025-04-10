package com.blockedu.BlockEdu.data.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class UploadCredentialRequest {
    @NotBlank
    private String studentId;
    @NotBlank
    @Email
    private String studentMail;
    @NotBlank
    private String institutionId;
    @NotBlank
    private String institutionName;
    @NotBlank
    private File transcript;
    @NotBlank
    private File certificate;
}

