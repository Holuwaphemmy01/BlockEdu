package com.blockedu.BlockEdu.service.email_service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class VerificationCode {


    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static String generateVerificationCode() {

        StringBuilder verificationCode = new StringBuilder(8);
        for (int index = 0; index < 8; index++) {
            verificationCode.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return verificationCode.toString();
    }

}
