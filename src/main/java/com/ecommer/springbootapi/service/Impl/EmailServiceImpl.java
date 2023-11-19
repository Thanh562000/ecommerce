package com.ecommer.springbootapi.service.Impl;

import com.ecommer.springbootapi.entities.Product;
import com.ecommer.springbootapi.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Override
    public void sendConfirmationEmail(Product obj) {

    }

    @Override
    public void sendEmail(SimpleMailMessage msg) {

    }

    @Override
    public void sendConfirmationEmailHtml(Product obj) {

    }

    @Override
    public void sendEmailHtml(MimeMessage msg) {

    }

    @Override
    public void sendNewPassword(String email, String newPassword) {

    }
}
