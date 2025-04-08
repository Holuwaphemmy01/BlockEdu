package com.blockedu.BlockEdu.service;

import com.blockedu.BlockEdu.repository.InstitutionRepository;
import com.blockedu.BlockEdu.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
//@AllArgsConstructor
public class DetailService implements UserDetailsService {


    private final StudentRepository studentRepository;
    private final InstitutionRepository institutionRepository;



    public DetailService(StudentRepository studentRepository, InstitutionRepository institutionRepository) {
        this.studentRepository = studentRepository;
        this.institutionRepository = institutionRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
