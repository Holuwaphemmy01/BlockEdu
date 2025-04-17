package com.blockedu.BlockEdu.service.email_service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerateRandomNumber {

    public int generateRandomNumber() {
        Random rand = new Random();
        return 100000+ rand.nextInt(900000);
    }

}
