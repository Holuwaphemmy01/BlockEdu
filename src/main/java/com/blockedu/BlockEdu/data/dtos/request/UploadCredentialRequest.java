package com.blockedu.BlockEdu.data.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
public class UploadCredentialRequest {
    @NotBlank
    @NotNull
    private String studentId;
    @NotBlank
    @NotNull
    @Email
    private String studentMail;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastName;
    @NotBlank
    @NotNull
    private String institutionId;
    @NotBlank
    private String institutionName;
    private MultipartFile transcript;
    private MultipartFile certificate;
}

