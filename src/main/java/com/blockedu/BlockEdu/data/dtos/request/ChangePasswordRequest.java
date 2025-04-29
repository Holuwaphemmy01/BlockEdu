package com.blockedu.BlockEdu.data.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordRequest {
    private String studentMail;
    private String studentId;
    private String firstName;
    private String lastName;
    private String newPassword;

}
