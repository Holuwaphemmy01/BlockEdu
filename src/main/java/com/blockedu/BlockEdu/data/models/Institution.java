package com.blockedu.BlockEdu.data.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Institution {
    @Id
    private UUID id;
    private String name;
    private String motto;
    private String address;
    private String state;
    private String city;
    private String Admin;
    private String officialMail;
    private String officialPhone;
    private String institutionType;
    private String twitter;
    private String facebook;
    private String linkedin;
    private String instagram;
    @OneToMany
    private List<Student> student;


}
