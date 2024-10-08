package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.dto.request.LoginRequestDTO;
import com.nocountry.nocountry.dto.request.RegisterRequestDTO;
import com.nocountry.nocountry.dto.response.AuthResponseDTO;
import com.nocountry.nocountry.dto.response.ErrorResponseDTO;
import com.nocountry.nocountry.security.oauth2.user.CurrentUser;
import com.nocountry.nocountry.security.oauth2.user.UserPrincipal;
import com.nocountry.nocountry.services.AuthService;
import io.jsonwebtoken.security.SignatureException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController()
@RequestMapping("/api/auth")
public class AuthController {

    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {

        AuthResponseDTO response = authService.login(loginRequestDTO);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
        AuthResponseDTO response = authService.register(registerRequestDTO);
        // Envio de correo de confirmacion del registro
//        emailService.registerConfirmation(registerRequestDTO.getUsername());
        return ResponseEntity.status(201).body(response);
    }


    @GetMapping("/check-login")
    public ResponseEntity<?> checkLogin(@CurrentUser UserPrincipal userPrincipal) {
        try {
            if (userPrincipal != null) {
                AuthResponseDTO response = authService.getUserByUsername(userPrincipal.getUsername());
                return ResponseEntity.status(200).body(response);
            } else {
                ErrorResponseDTO error = new ErrorResponseDTO("Forbidden", HttpStatus.UNAUTHORIZED,"/api/check-out",LocalDateTime.now());
                return ResponseEntity.status(403).body(error);
            }
        } catch (SignatureException e) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO("Invalid token", HttpStatus.UNAUTHORIZED, "Token is invalid or tampered with",LocalDateTime.now());
            return ResponseEntity.status(401).body(errorResponse);
        } catch (Exception e) {
            ErrorResponseDTO errorResponse = new ErrorResponseDTO("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del servidor",LocalDateTime.now());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @GetMapping("/saludo")
    public String saludo() {
        return "Hola";
    }
}