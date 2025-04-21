package com.blockedu.BlockEdu.data.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DownloadCredentialsRequest {

    @NotBlank
    private String studentId;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
