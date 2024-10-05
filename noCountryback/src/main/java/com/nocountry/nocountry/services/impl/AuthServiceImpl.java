package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.config.mapper.UserMapper;
import com.nocountry.nocountry.dto.request.LoginRequestDTO;
import com.nocountry.nocountry.dto.request.RegisterRequestDTO;
import com.nocountry.nocountry.dto.response.AuthResponseDTO;
import com.nocountry.nocountry.exceptions.BadRequestException;
import com.nocountry.nocountry.exceptions.NotFoundException;
import com.nocountry.nocountry.models.Role;
import com.nocountry.nocountry.models.User;
import com.nocountry.nocountry.repository.RoleRepo;
import com.nocountry.nocountry.repository.UserRepo;
import com.nocountry.nocountry.security.filter.JwtUtils;
import com.nocountry.nocountry.services.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class AuthServiceImpl implements AuthService {



    @Autowired
    private UserMapper userMapper;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    private RoleRepo roleRepo;


    private AuthenticationManager authenticationManager;


    private JwtUtils jwtUtils;
    public AuthServiceImpl( UserRepo userRepo, PasswordEncoder passwordEncoder, RoleRepo roleRepo, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleRepo = roleRepo;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }


    public AuthServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    @Transactional
    public AuthResponseDTO login(LoginRequestDTO dto) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            dto.getUsername(), dto.getPassword()));
        } catch (Exception e) {
            throw new BadRequestException("Invalid username or password");
        }
        User user = userRepo.findByEmail(dto.getUsername()).orElseThrow(
                () -> new NotFoundException("User not found with username: " + dto.getUsername()));
       return generateResponse(user);
    }

    @Transactional
    public AuthResponseDTO register(RegisterRequestDTO registerRequestDTO) {
        Optional<User> userFound = userRepo.findByEmail(registerRequestDTO.getUsername());
        if (userFound.isPresent()) {
            throw new BadRequestException("Email already registered");
        }
        User user = new User();
        user.setEmail(registerRequestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        UUID idRandom = UUID.randomUUID();
        Role role = roleRepo.findById(idRandom).orElseThrow(() -> new NotFoundException(String.format("Role not found with id: %s",idRandom)));
        user.getRoles().add(role);
        userRepo.save(user);

        return generateResponse(user);

    }
    @Override
    public AuthResponseDTO getUserByUsername(String username) {
        User user = userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return generateResponse(user);
    }



    private AuthResponseDTO generateResponse(User user) {
        String token = jwtUtils.generateToken(user);
        return new AuthResponseDTO(userMapper.toUserResponseDTO(user), token);
    }
}
