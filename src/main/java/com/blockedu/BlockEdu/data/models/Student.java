package com.blockedu.BlockEdu.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity

@Getter
@Setter
@ToString
public class Student {
    @Id
    private String studentId;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastName;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    private boolean firstTimer=true;
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;
    private String credentialsUploadId;
}
