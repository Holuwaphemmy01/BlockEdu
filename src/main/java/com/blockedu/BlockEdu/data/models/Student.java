package com.blockedu.BlockEdu.data.models;

import jakarta.persistence.*;

import java.io.File;

@Entity

public class Student {
    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    private File certificate;
    private File transcript;
    private String email;
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

}
