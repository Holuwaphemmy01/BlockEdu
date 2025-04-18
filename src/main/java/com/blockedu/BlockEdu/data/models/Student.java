package com.blockedu.BlockEdu.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity

@Getter
@Setter
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
    @NotBlank
    private String firstPassword;
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;
    private String credentialsUploadId;
}
