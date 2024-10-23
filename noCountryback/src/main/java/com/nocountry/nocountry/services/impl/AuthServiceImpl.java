package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.config.mapper.UserMapper;
import com.nocountry.nocountry.dto.request.LoginRequestDTO;
import com.nocountry.nocountry.dto.request.RegisterRequestDTO;
import com.nocountry.nocountry.dto.response.UserResponseDTO;
import com.nocountry.nocountry.exceptions.BadRequestException;
import com.nocountry.nocountry.exceptions.EmailServiceException;
import com.nocountry.nocountry.exceptions.NotFoundException;
import com.nocountry.nocountry.models.Role;
import com.nocountry.nocountry.models.User;
import com.nocountry.nocountry.repository.RoleRepo;
import com.nocountry.nocountry.repository.UserRepo;
import com.nocountry.nocountry.security.filter.JwtUtils;
import com.nocountry.nocountry.services.AuthService;
import com.nocountry.nocountry.utils.CookieUtils;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired

    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;


    public AuthServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    @Transactional
    public UserResponseDTO login(LoginRequestDTO dto, HttpServletResponse resp) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            dto.getEmail(), dto.getPassword()));
        } catch (Exception e) {
            throw new BadRequestException("Invalid username or password");
        }
        User user = userRepo.findByEmail(dto.getEmail()).orElseThrow(
                () -> new NotFoundException("User not found with username: " + dto.getEmail()));
       return generateResponse(user,resp);
    }


    @Transactional
    public UserResponseDTO register(RegisterRequestDTO registerRequestDTO, HttpServletResponse resp) {
        Optional<User> userFound = userRepo.findByEmail(registerRequestDTO.getEmail());
        if (userFound.isPresent()) {
            throw new BadRequestException("Email already registered");
        }
        User user = new User();
        user.setEmail(registerRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        UUID roleId = UUID.fromString("340ddc49-1214-4e00-9a77-2334334b23d3");
        Role role = roleRepo.findById(roleId).orElseThrow(() -> new NotFoundException(String.format("Role not found with id: %s",roleId)));
        user.setRoles(Collections.singletonList(role));
        userRepo.save(user);
        return generateResponse(user,resp);

    }
    @Override
    public UserResponseDTO getUserByUsername(String username, HttpServletResponse resp) {
        User user = userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return generateResponse(user,resp);
    }

    private UserResponseDTO generateResponse(User user, HttpServletResponse response) {
        String token = jwtUtils.generateToken(user.getUsername(),user.getId());
        CookieUtils.addCookie(response,"token",token,3600);
        return userMapper.toUserResponseDTO(user);
    }

    public Optional<String> getUserNameByEmail(String email) {
        Optional<User> userOptional = userRepo.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return Optional.ofNullable(user.getProfile().getProfileName());
        }
        return Optional.empty();
    }

    @Transactional
    public void updatePasswordToken(String token, String email) {
        Optional<User> optionalUsuario = userRepo.findByEmail(email);
        if (optionalUsuario.isPresent()) {
            User user = optionalUsuario.get();
            user.setResetPasswordToken(token);
            userRepo.save(user);
        } else {
            try {
                throw new EmailServiceException("User not found with email: " + email);
            } catch (EmailServiceException e) {
                throw new RuntimeException("Error processing password recovery request", e);
            }
        }
    }

    public User get(String resetPasswordToken) {
        if (resetPasswordToken == null) {
            try {
                throw new EmailServiceException("Token not provided.");
            } catch (EmailServiceException e) {
                throw new RuntimeException("Error al finalizar el restablecimiento de contraseña. Solicite un nuevo token.", e);
            }
        }
        Optional<User> optionalUsuario = userRepo.findByResetPasswordToken(resetPasswordToken);
        if (optionalUsuario.isPresent()) {
            return optionalUsuario.get();
        } else {
            try {
                throw new EmailServiceException("Invalid or expired token.");
            } catch (EmailServiceException e) {
                throw new RuntimeException("Error al finalizar el restablecimiento de contraseña. Solicite un nuevo token.", e);
            }
        }
    }

    @Transactional
    public void updatePassword(User user, String password) {
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setResetPasswordToken(null);
        userRepo.save(user);
    }
}
