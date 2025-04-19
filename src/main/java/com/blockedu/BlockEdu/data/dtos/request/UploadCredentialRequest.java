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
    private String studentId;
    @NotBlank
    @Email
    private String studentMail;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String institutionId;
    @NotBlank
    private String institutionName;
//    private MultipartFile transcript;
    private MultipartFile certificate;
}

