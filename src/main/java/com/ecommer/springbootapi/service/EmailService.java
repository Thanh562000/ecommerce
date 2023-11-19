package com.ecommer.springbootapi.service;

import com.ecommer.springbootapi.entities.Product;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendConfirmationEmail(Product obj);
    void sendEmail(SimpleMailMessage msg);

    void sendConfirmationEmailHtml(Product obj);
    void sendEmailHtml(MimeMessage msg);

    void sendNewPassword(String email, String newPassword);
}
