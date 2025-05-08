package com.blockedu.BlockEdu.service.student.change_password;

import com.blockedu.BlockEdu.data.dtos.request.ChangePasswordRequest;
import com.blockedu.BlockEdu.data.dtos.response.ChangePasswordResponse;
import com.blockedu.BlockEdu.data.models.Student;
import com.blockedu.BlockEdu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {

    @Autowired
    private StudentRepository  studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ChangePasswordResponse changePassword(ChangePasswordRequest request) {

        Optional <Student> studentOptional = studentRepository.findByStudentId(request.getStudentId());
        if (studentOptional.isEmpty()) throw new IllegalArgumentException("Student not found");

        if(!studentOptional.get().getFirstName().equalsIgnoreCase(request.getFirstName())) throw new IllegalArgumentException("First name not match");
        if(!studentOptional.get().getLastName().equalsIgnoreCase(request.getLastName())) throw new IllegalArgumentException("Last name not match");
        if(!studentOptional.get().getEmail().equalsIgnoreCase(request.getStudentMail())) throw new IllegalArgumentException("Email not match");


        Student student = studentOptional.get();
        student.setPassword(passwordEncoder.encode(request.getNewPassword()));
        student.setFirstLogin(false);
        studentRepository.save(student);
        ChangePasswordResponse response = new ChangePasswordResponse();
        response.setStudentId(student.getStudentId());
        response.setEmail(request.getStudentMail());
        response.setLastName(request.getLastName());
        response.setFirstName(request.getFirstName());
        return response;

    }
}
