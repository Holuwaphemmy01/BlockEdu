package com.blockedu.BlockEdu.service.login;

import com.blockedu.BlockEdu.data.dtos.request.UserLoginRequest;
import com.blockedu.BlockEdu.data.dtos.response.LoginResponse;
import com.blockedu.BlockEdu.data.models.Institution;
import com.blockedu.BlockEdu.data.models.Student;
import com.blockedu.BlockEdu.mapper.InstitutionLoginMap;
import com.blockedu.BlockEdu.repository.InstitutionRepository;
import com.blockedu.BlockEdu.repository.StudentRepository;
import com.blockedu.BlockEdu.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        String token = jwtTokenProvider.generateToken(authentication);
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        LoginResponse response = new LoginResponse();

        Optional<Student> student = studentRepository.findByEmail(request.getEmail());
        Optional<Institution> institution = institutionRepository.findByOfficialMail(request.getEmail());


        if(student.isPresent()) {
            response.setStudentId(student.get().getStudentId());
            response.setFirstName(student.get().getFirstName());
            response.setLastName(student.get().getLastName());
            response.setEmail(student.get().getEmail());
            response.setRole(role);
            response.setToken(token);
            response.setStudentFirstLogin(student.get().isFirstLogin());
            return response;
        }


        else if(institution.isPresent()) {

            response.setId(institution.get().getId());
            response.setName(institution.get().getName());
            response.setOfficialMail(institution.get().getOfficialMail());
            response.setRole(role);
            response.setToken(token);
            response.setAdmin(institution.get().getAdmin());
            response.setMotto(institution.get().getMotto());
            response.setId(institution.get().getId());
            return response;
        }

        else throw new IllegalArgumentException("Invalid email or password");




    }
}
