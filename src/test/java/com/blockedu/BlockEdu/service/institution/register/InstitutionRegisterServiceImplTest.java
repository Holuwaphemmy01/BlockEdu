package com.blockedu.BlockEdu.service.institution.register;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionRegisterRequest;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AllArgsConstructor
public class InstitutionRegisterServiceImplTest {

    private InstitutionRegisterServiceImpl institutionRegisterServiceImpl;


    @Test
    public void testThatInstitutionNameCannotBeEmptyOrNull(){
        InstitutionRegisterRequest request = new InstitutionRegisterRequest();
        request.setName("");
        assertThrows(IllegalArgumentException.class, () -> institutionRegisterServiceImpl.register(request));
    }
}