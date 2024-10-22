package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.dto.request.LoginRequestDTO;
import com.nocountry.nocountry.dto.request.RegisterRequestDTO;
import com.nocountry.nocountry.dto.response.UserResponseDTO;
import com.nocountry.nocountry.exceptions.UnAuthorizedException;
import com.nocountry.nocountry.security.oauth2.user.CurrentUser;
import com.nocountry.nocountry.security.oauth2.user.UserPrincipal;
import com.nocountry.nocountry.services.AuthService;
import com.nocountry.nocountry.services.IEmailService;
import com.nocountry.nocountry.utils.CookieUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController()
@RequestMapping("/api/auth")
public class AuthController {
    private final IEmailService emailService;
    AuthService authService;
    public AuthController(IEmailService emailService, AuthService authService) {
        this.emailService = emailService;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse resp) {
        emailService.registerConfirmation("verasdiegoca78@gmail.com");
//        AuthResponseDTO response = authService.login(loginRequestDTO,resp);
        UserResponseDTO response = authService.login(loginRequestDTO,resp);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody RegisterRequestDTO registerRequestDTO, HttpServletResponse resp) {
        UserResponseDTO response = authService.register(registerRequestDTO, resp);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/check-login")
    public ResponseEntity<?> checkLogin(@CurrentUser UserPrincipal userPrincipal, HttpServletResponse resp) {
        log.info("Current user check login{}", userPrincipal.getName());
        if (userPrincipal== null) throw new UnAuthorizedException("Forbidden");
        UserResponseDTO response = authService.getUserByUsername(userPrincipal.getUsername(),resp);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse resp, HttpServletRequest request){
        CookieUtils.deleteCookie(request,resp,"token");
        return ResponseEntity.ok().build();
    }
}
