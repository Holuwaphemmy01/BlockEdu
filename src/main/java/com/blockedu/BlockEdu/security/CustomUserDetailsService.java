package com.blockedu.BlockEdu.security;

import com.blockedu.BlockEdu.data.models.Institution;
import com.blockedu.BlockEdu.data.models.Student;
import com.blockedu.BlockEdu.repository.InstitutionRepository;
import com.blockedu.BlockEdu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final InstitutionRepository institutionRepository;

    @Autowired
    public CustomUserDetailsService(StudentRepository studentRepository, InstitutionRepository institutionRepository) {
        this.studentRepository = studentRepository;
        this.institutionRepository = institutionRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Institution> institutionOpt = institutionRepository.findByOfficialMail(email);
        if (institutionOpt.isPresent()) {
            Institution institution = institutionOpt.get();
            return new CustomUserDetails(
                    institution.getOfficialMail(),
                    institution.getPassword(),
                    "INSTITUTION"
            );
        }

        Optional<Student> studentOpt = studentRepository.findByEmail(email);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            return new CustomUserDetails(
                    student.getEmail(),
                    student.getPassword(),
                    "STUDENT"
            );
        }

        throw new UsernameNotFoundException("Invalid email: ");
    }
}
