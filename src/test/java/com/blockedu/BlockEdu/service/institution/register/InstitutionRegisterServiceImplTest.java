package com.blockedu.BlockEdu.service.institution.register;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionRegisterRequest;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionRegisterResponse;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InstitutionRegisterServiceImplTest {

    @Autowired
    private InstitutionRegisterServiceImpl institutionRegisterServiceImpl;


    @DisplayName("Test to register institution successfully")
    @Test
    public void testToRegisterInstitutionSuccessfully(){
        InstitutionRegisterRequest request = new InstitutionRegisterRequest();
        request.setName("Oluwafemi");
        request.setMotto("Femi");
        request.setAddress("Adelek street");
        request.setState("Ogun");
        request.setCity("Sagamu");
        request.setAdmin("Esther");
        request.setOfficialMail("Oluwafemi@gmail.com");
        request.setOfficialPhone("09025540752");
        request.setInstitutionType("Private");
        request.setEmail("Oluwafemi2002@gmail.com");
        request.setPassword("727727272");
        InstitutionRegisterResponse response = institutionRegisterServiceImpl.register(request);
        assertNotNull(response);
        assertEquals("Oluwafemi", response.getName());
        assertEquals("Femi", response.getMotto());
        assertEquals("Adelek street", response.getAddress());
    }
}