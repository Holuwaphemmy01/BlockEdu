package com.blockedu.BlockEdu.data.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadCredentialResponse {
    private String studentId;
    private String studentMail;
    private String firstName;
    private String lastName;

}
