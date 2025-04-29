package com.blockedu.BlockEdu.service.student.generate;

import com.blockedu.BlockEdu.data.dtos.request.StudentGenerateUrlRequest;
import com.blockedu.BlockEdu.data.models.Student;
import com.blockedu.BlockEdu.data.models.StudentUrlData;
import com.blockedu.BlockEdu.repository.StudentRepository;
import com.blockedu.BlockEdu.repository.StudentUrlDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GenerateUrlService implements GenerateUrl{

    @Autowired
    private StudentUrlDataRepository urlDataRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public String generateUrl(StudentGenerateUrlRequest request) {

        StudentUrlData urlData = new StudentUrlData();

        Optional<Student> student = studentRepository.findByStudentId(request.getStudentId());

        if (student.isEmpty()) throw new IllegalArgumentException("Student not found");

        urlData.setFirstName(student.get().getFirstName());
        urlData.setLastName(student.get().getLastName());
        urlData.setEmail(student.get().getEmail());
        urlData.setInstitutionName(student.get().getInstitution().getName());
        urlData.setBlockChainAddress("0xtwt7owk222sj7gs4bs200enns00r555suw529msb");
        urlData.setInstitutionMotto(student.get().getInstitution().getMotto());
        urlData.setStudentId(student.get().getStudentId());
        urlDataRepository.save(urlData);

        return "/auth/" + urlData.getId();
    }
}
