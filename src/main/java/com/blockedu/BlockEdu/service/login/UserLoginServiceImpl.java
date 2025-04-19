package com.blockedu.BlockEdu.service.login;

import com.blockedu.BlockEdu.data.dtos.request.UserLoginRequest;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionLoginResponse;
import com.blockedu.BlockEdu.data.dtos.response.LoginResponse;
import com.blockedu.BlockEdu.data.models.Institution;
import com.blockedu.BlockEdu.data.models.Student;
import com.blockedu.BlockEdu.repository.InstitutionRepository;
import com.blockedu.BlockEdu.repository.StudentRepository;
import com.blockedu.BlockEdu.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @Override
    public LoginResponse login(UserLoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        String token = jwtTokenProvider.generateToken(authentication);
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        // Try to find in Institution
        Optional<Institution> institutionOpt = institutionRepository.findByOfficialMail(request.getEmail());

        if (institutionOpt.isPresent()) {
            Institution institution = institutionOpt.get();
            InstitutionLoginResponse response = institutionLoginMap.toResponse(institution);
            response.setToken(token);
            response.setRole(role);
            response.setId(institution.getId());
            return response;
        }

        // Try to find in Student
        Optional<Student> studentOpt = studentRepository.findByEmail(request.getEmail());

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            StudentLoginResponse response = studentLoginMap.toResponse(student);
            response.setToken(token);
            response.setRole(role);
            response.setId(student.getId());
            return response;
        }

        throw new UsernameNotFoundException("User not found in both Institution and Student");

    }
}
