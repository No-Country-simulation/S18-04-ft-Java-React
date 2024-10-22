package com.nocountry.nocountry.services;

public interface IEmailService {
    void sendPasswordRecoveryEmail(String email, String resetPasswordLink);
    void sendEmail(String toMessage, String toEmail, String userName, String senderName);
    void registerConfirmation(String toEmail);
    void sendPasswordChangeConfirmationEmail(String email);
}
