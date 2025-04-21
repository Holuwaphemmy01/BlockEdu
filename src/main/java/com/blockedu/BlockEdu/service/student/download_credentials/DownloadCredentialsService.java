package com.blockedu.BlockEdu.service.student.download_credentials;

import com.blockedu.BlockEdu.data.dtos.request.DownloadCredentialsRequest;
import com.blockedu.BlockEdu.data.dtos.response.DownloadCredentialsResponse;
import com.blockedu.BlockEdu.data.models.Student;
import com.blockedu.BlockEdu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DownloadCredentialsService implements DownloadCredentials {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DownloadCredentialsResponse download(DownloadCredentialsRequest request) {

        Optional<Student> student = studentRepository.findById(UUID.fromString(request.getStudentId()));
        if (student.isPresent()) {
            if(!student.get().getFirstName().equalsIgnoreCase(request.getFirstName()) && student.get().getLastName().equalsIgnoreCase(request.getLastName()))
                throw new IllegalArgumentException("Student not found");
        }


        String blobId = student.get().getCredentialsUploadId();





        return null;
    }
}
