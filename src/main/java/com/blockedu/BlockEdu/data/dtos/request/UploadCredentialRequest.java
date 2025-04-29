package com.blockedu.BlockEdu.data.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@ToString
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

