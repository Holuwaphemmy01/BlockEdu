package com.blockedu.BlockEdu.service.email_service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailService {


    private JavaMailSender mailSender;


    @Value("${app.mail}")
    private String appMail;


    public void sendVerificationCode(String receiverMail, String firstName, String lastName) {
        String code = VerificationCode.generateVerificationCode();
        String body = String.format("""
                Dear %s %s,
                To have access to your credentials on BlockEdu platform  
                This is your log-in details
                Email: %s
                Password: %s
                """, firstName, lastName, receiverMail, code);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(receiverMail);
        message.setSubject(firstName + " " + lastName);




    }

}
