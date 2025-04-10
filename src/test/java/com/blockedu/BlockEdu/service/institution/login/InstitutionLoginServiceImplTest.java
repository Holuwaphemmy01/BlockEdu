package com.blockedu.BlockEdu.service.institution.login;

import com.blockedu.BlockEdu.data.dtos.request.InstitutionLoginRequest;
import com.blockedu.BlockEdu.data.dtos.request.InstitutionRegisterRequest;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionLoginResponse;
import com.blockedu.BlockEdu.data.dtos.response.InstitutionRegisterResponse;
import com.blockedu.BlockEdu.service.institution.register.InstitutionRegisterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InstitutionLoginServiceImplTest {

    @Autowired
    private InstitutionLoginServiceImpl institutionLoginService;

    @Autowired
    private InstitutionRegisterService institutionRegisterServiceImpl;


    @DisplayName("RegisterUserCanLoginSuccessfully")
    @Test
    public void testThatARegisterInstitutionCanLoginSuccessfully() {

        InstitutionRegisterRequest request = getInstitutionRegisterRequest();
        InstitutionRegisterResponse response = institutionRegisterServiceImpl.register(request);
            assertNotNull(response);
            assertEquals("Oluwafemi", response.getName());
            assertEquals("Femi", response.getMotto());
            assertEquals("Adelek street", response.getAddress());

            //login now
        InstitutionLoginRequest loginRequest = new InstitutionLoginRequest();
        loginRequest.setOfficialMail(request.getOfficialMail());
        loginRequest.setPassword(request.getPassword());
        InstitutionLoginResponse institutionLoginResponse = institutionLoginService.login(loginRequest);
        assertNotNull(institutionLoginResponse);
        assertEquals("Oluwafemi", institutionLoginResponse.getName());
        assertEquals("Femi", institutionLoginResponse.getMotto());

        }




    private static InstitutionRegisterRequest getInstitutionRegisterRequest() {
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
        return request;
    }


}

