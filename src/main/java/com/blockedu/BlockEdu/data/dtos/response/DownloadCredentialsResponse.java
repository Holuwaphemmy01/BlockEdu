package com.blockedu.BlockEdu.data.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;
import java.util.Date;

@Getter
@Setter
public class DownloadCredentialsResponse {

    private byte[] file;
    private String studentName;
    private String studentId;
    private String institutionName;
    private String institutionMotto;
    private Date issuanceDate;
    private Timestamp issuanceTime;
    private String blockChainAddress;

}
