package com.blockedu.BlockEdu.security;

import com.blockedu.BlockEdu.repository.InstitutionRepository;
import com.blockedu.BlockEdu.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final InstitutionRepository institutionRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return studentRepository.findByEmail(email)
                .map(student -> new CustomUserDetails(student.getEmail(), student.getPassword(), "ROLE_STUDENT"))
                .or (() -> institutionRepository.findByEmail(email)
                        .map(institution -> new CustomUserDetails(institution.getEmail(), institution.getPassword(), "ROLE_INSTITUTION")))
                .orelseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

    }
}
