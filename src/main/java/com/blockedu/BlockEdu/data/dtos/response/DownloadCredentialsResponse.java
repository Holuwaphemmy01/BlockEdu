package com.blockedu.BlockEdu.data.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
public class DownloadCredentialsResponse {

    private MultipartFile file;
    private String studentName;
    private String studentId;
    private String institutionName;
    private String institutionId;
    private Date issuanceDate;
    private String BlockChain;

}
