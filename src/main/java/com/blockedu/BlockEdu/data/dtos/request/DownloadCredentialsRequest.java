package com.blockedu.BlockEdu.data.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DownloadCredentialsRequest {

    private String studentId;
    private String firstName;
    private String lastName;
}
