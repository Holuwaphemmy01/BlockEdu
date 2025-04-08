package com.blockedu.BlockEdu.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Entity

@Getter
@Setter
public class Student {
    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    private File certificate;
    private File transcript;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;
}
