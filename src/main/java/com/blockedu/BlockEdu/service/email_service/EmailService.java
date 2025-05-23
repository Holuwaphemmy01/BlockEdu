package com.blockedu.BlockEdu.service.email_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String appMail;


    public String sendVerificationCode(String receiverMail, String firstName, String lastName) {
        String code = VerificationCode.generateVerificationCode();
        String body = String.format("""
                Dear %s %s,
                To have access to your credentials on BlockEdu platform
                This is your log-in details
                Email: %s
                Password: %s
                https://block-edu-front-end.vercel.app/login
                """, firstName, lastName, receiverMail, code);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(receiverMail);
        message.setSubject("BlockEdu Login details");
        message.setText(body);
        message.setFrom(appMail);
        mailSender.send(message);

        return code;
    }

}
