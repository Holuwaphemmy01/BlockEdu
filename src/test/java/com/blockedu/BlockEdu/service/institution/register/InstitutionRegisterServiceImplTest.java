package com.blockedu.BlockEdu.service.institution.register;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionRegisterRequest;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionRegisterResponse;
import com.blockedu.BlockEdu.exception.DuplicateInstitutionException;
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
        request.setPassword("727727272");
        InstitutionRegisterResponse response = institutionRegisterServiceImpl.register(request);
        assertNotNull(response);
        assertEquals("Oluwafemi", response.getName());
        assertEquals("Femi", response.getMotto());
        assertEquals("Adelek street", response.getAddress());
    }


    @DisplayName("Test to throw exception when you register with an existing institution name")
    @Test
    public void testToThrowExceptionWhenYouRegisterWithExistingInstitutionName(){
        InstitutionRegisterRequest request = new InstitutionRegisterRequest();
        request.setName("Oluwafemi");
        request.setMotto("Femi");
        request.setAddress("Adeleke street");
        request.setState("Ogun");
        request.setCity("Sagamu");
        request.setAdmin("Esther");
        request.setOfficialMail("Oluwafemi@gmail.com");
        request.setOfficialPhone("09025540752");
        request.setInstitutionType("Private");
        request.setPassword("727727272");
        DuplicateInstitutionException exception = assertThrows(DuplicateInstitutionException.class, () -> institutionRegisterServiceImpl.register(request));
        assertEquals("Name already exists", exception.getMessage());
    }

}