package com.blockedu.BlockEdu.data.dtos.request;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class InstitutionRegisterRequestTest {
    private Validator validator;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidInstitution() {
        InstitutionRegisterRequest institution = new InstitutionRegisterRequest();
        institution.setName("Spring University");
        institution.setMotto("Learn. Grow. Lead.");
        institution.setAddress("123 Main St");
        institution.setState("Lagos");
        institution.setCity("Ikeja");
        institution.setAdmin("John Doe");
        institution.setOfficialMail("admin@springuni.edu");
        institution.setOfficialPhone("08012345678");
        institution.setInstitutionType("Private");
        institution.setPassword("securePassword");

        Set<ConstraintViolation<InstitutionRegisterRequest>> violations = validator.validate(institution);
        assertTrue(violations.isEmpty(), "There should be no validation errors");
    }

    @Test
    public void testInvalidInstitution_missingFields() {
        InstitutionRegisterRequest institution = new InstitutionRegisterRequest(); // all fields are null/empty

        Set<ConstraintViolation<InstitutionRegisterRequest>> violations = validator.validate(institution);
        assertFalse(violations.isEmpty(), "Validation should fail for missing required fields");

        violations.forEach(violation ->
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage()));
    }
  
}




