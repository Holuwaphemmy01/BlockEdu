package com.blockedu.BlockEdu.data.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.xml.transform.Source;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Institution  {
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
    private String password;
//    private String twitter;
//    private String facebook;
//    private String linkedin;
//    private String instagram;
@OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
private List<Student> student;


}
