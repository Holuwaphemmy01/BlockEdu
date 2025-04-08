package com.blockedu.BlockEdu.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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


    public File getTranscript() {
        return transcript;
    }

    public void setTranscript(File transcript) {
        this.transcript = transcript;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public File getCertificate() {
        return certificate;
    }

    public void setCertificate(File certificate) {
        this.certificate = certificate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
