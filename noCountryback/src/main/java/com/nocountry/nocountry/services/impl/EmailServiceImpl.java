package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.exceptions.EmailServiceException;
import com.nocountry.nocountry.services.IEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;

@Service
public class EmailServiceImpl implements IEmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    private final AuthServiceImpl authService ;

    public static final String REGISTRATION_CONFIRMATION_SUBJECT = "Gracias por registrarte en nuestro sitio.";
    public static final String PASSWORD_CHANGE_CONFIRMATION_SUBJECT = "Tu cambio de contraseña fue exitoso.";
    public static final String PASSWORD_RECOVERY_SUBJECT = "Password Recovery Request";
    public static final String SUPPORT_NAME = "Soporte";
    public static final String WELCOME_TEAM_NAME = "Equipo de Bienvenida";
    public static final String PASSWORD_RECOVERY_TEMPLATE = "password-recovery";
    public static final String CONFIRMATION_TEMPLATE = "confirmation";
    public static final String DEFAULT_USER_NAME = "Usuario";

    public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine, AuthServiceImpl authService) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        this.authService  = authService ;
    }

    @Value("spring.mail.username")
    private String emailSender;

    /**
     * Sends an email for password recovery.
     *
     * @param toEmail          The recipient's email address.
     * @param resetPasswordLink The link to reset the password.
     * @throws EmailServiceException if an error occurs while sending the email.
     */
    @Override
    public void sendPasswordRecoveryEmail(String toEmail, String resetPasswordLink) {
        try {
            String userName = getUserNameByEmail(toEmail);
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(emailSender, SUPPORT_NAME);
            helper.setTo(toEmail);
            helper.setSubject(PASSWORD_RECOVERY_SUBJECT);

            Context context = new Context();
            context.setVariable("resetPasswordLink", resetPasswordLink);
            context.setVariable("userName", userName);
            String htmlContent = templateEngine.process(PASSWORD_RECOVERY_TEMPLATE, context);

            helper.setText(htmlContent, true);
            javaMailSender.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new EmailServiceException("Failed to send password recovery email", e);
        }
    }

    /**
     * Sends a generic email with the provided subject and content.
     *
     * @param subject    The subject of the email.
     * @param toEmail    The recipient's email address.
     * @param userName   The name of the user receiving the email.
     * @param senderName The name of the sender displayed in the email.
     * @throws EmailServiceException if an error occurs while sending the email.
     */
    @Override
    public void sendEmail(String subject, String toEmail, String userName, String senderName) {
        String emailTitle, messageBody, extraMessage = null;
        switch (subject) {
            case REGISTRATION_CONFIRMATION_SUBJECT:
                emailTitle = "Confirmación de Registro";
                messageBody = "¡Bienvenido!, tu registro en No Country ha sido exitoso.";
                extraMessage = "Si tienes alguna duda, no dudes en contactarnos.";
                break;

            case PASSWORD_CHANGE_CONFIRMATION_SUBJECT:
                emailTitle = "Confirmación de Cambio de Contraseña";
                messageBody = "Tu contraseña ha sido actualizada con éxito en No Country.";
                extraMessage = "Si no solicitaste este cambio, por favor, contacta con nuestro soporte de inmediato.";
                break;

            default:
                throw new IllegalArgumentException("Tipo de email no soportado: " + subject);
        }
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(emailSender, senderName);
            helper.setTo(toEmail);
            helper.setSubject(subject);

            Context context = new Context();
            context.setVariable("emailTitle", emailTitle);
            context.setVariable("userName", userName);
            context.setVariable("messageBody", messageBody);
            context.setVariable("extraMessage", extraMessage);
            String htmlContent = templateEngine.process(CONFIRMATION_TEMPLATE, context);

            helper.setText(htmlContent, true);
            javaMailSender.send(message);
        } catch (MessagingException | UnsupportedEncodingException e ) {
            throw new EmailServiceException("Failed to send password change confirmation email", e);
        }
    }

    @Override
    public void registerConfirmation(String toEmail) {
        String userName = getUserNameByEmail(toEmail);
        sendEmail(REGISTRATION_CONFIRMATION_SUBJECT, toEmail, userName, WELCOME_TEAM_NAME);
    }

    @Override
    public void sendPasswordChangeConfirmationEmail(String toEmail) {
        String userName = getUserNameByEmail(toEmail);
        sendEmail(PASSWORD_CHANGE_CONFIRMATION_SUBJECT, toEmail, userName, SUPPORT_NAME);
    }

    private String getUserNameByEmail(String email) {
        return authService .getUserNameByEmail(email).orElse(DEFAULT_USER_NAME);
    }
}
