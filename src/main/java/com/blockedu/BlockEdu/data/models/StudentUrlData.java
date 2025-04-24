package com.blockedu.BlockEdu.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
public class StudentUrlData {
    @Id
    private String id = UUID.randomUUID().toString();

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime expiresAt = createdAt.plusHours(1);

    @Lob
    private byte[] content;

    private String firstName;
    private String lastName;
    private String email;
    private String institutionName;
    private String institutionMotto;
    private String blockChainAddress;
    private Date credentialsDate;



}
