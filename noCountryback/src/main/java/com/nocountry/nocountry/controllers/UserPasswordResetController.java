package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.dto.request.PasswordRecoveryRequest;
import com.nocountry.nocountry.dto.request.PasswordResetRequest;
import com.nocountry.nocountry.dto.response.PasswordRecoveryResponse;
import com.nocountry.nocountry.models.User;
import com.nocountry.nocountry.services.IEmailService;
import com.nocountry.nocountry.services.impl.AuthServiceImpl;
import jakarta.validation.Valid;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserPasswordResetController {
    private final IEmailService emailService;
    private final AuthServiceImpl authService;

    @Value("${frontend.url}")
    private String frontendUrl;

    public UserPasswordResetController(IEmailService emailService, AuthServiceImpl authService) {
        this.emailService = emailService;
        this.authService = authService;
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<PasswordRecoveryResponse> requestPasswordReset(@Valid @RequestBody PasswordRecoveryRequest request) {
        String token = RandomString.make(45);
        authService.updatePasswordToken(token, request.email());
        String resetPasswordLink = String.format("%s/reset-password?token=%s", frontendUrl, token);
        emailService.sendPasswordRecoveryEmail(request.email(), resetPasswordLink);
        return ResponseEntity.ok(new PasswordRecoveryResponse("Email de recuperación de contraseña enviado."));
    }

    @GetMapping("/reset-password/token")
    public ResponseEntity<PasswordRecoveryResponse> validateResetToken(@RequestParam(value = "token") String token) {
        authService.get(token);
        return ResponseEntity.ok(new PasswordRecoveryResponse("Token válido. Puede proceder a restablecer su contraseña.", token));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<PasswordRecoveryResponse> resetPassword(@Valid @RequestBody PasswordResetRequest request) {
        User user = authService.get(request.token());
        authService.updatePassword(user, request.password());
        emailService.sendPasswordChangeConfirmationEmail(user.getEmail());
        return ResponseEntity.ok(new PasswordRecoveryResponse("Contraseña cambiada exitosamente. Ahora puedes iniciar sesión."));
    }
}
