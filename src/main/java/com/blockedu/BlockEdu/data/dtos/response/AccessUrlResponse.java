package com.blockedu.BlockEdu.data.dtos.response;


import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class AccessUrlResponse {
    private byte[] content;
    private String firstName;
    private String lastName;
    private String institutionName;
    private String institutionMotto;
    private String blockChainAddress;
    private LocalDateTime credentialsDate;

}
