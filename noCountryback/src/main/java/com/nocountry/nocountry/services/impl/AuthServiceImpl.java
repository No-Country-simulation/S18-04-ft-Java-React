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

import java.lang.reflect.Array;
import java.util.Arrays;
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
    public AuthResponseDTO login(LoginRequestDTO dto) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            dto.getEmail(), dto.getPassword()));
        } catch (Exception e) {
            throw new BadRequestException("Invalid username or password");
        }
        User user = userRepo.findByEmail(dto.getEmail()).orElseThrow(
                () -> new NotFoundException("User not found with username: " + dto.getEmail()));
       return generateResponse(user);
    }

    @Transactional
    public AuthResponseDTO register(RegisterRequestDTO registerRequestDTO) {
        Optional<User> userFound = userRepo.findByEmail(registerRequestDTO.getEmail());
        if (userFound.isPresent()) {
            throw new BadRequestException("Email already registered");
        }
        User user = new User();
        user.setEmail(registerRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        UUID roleId = UUID.fromString("340ddc49-1214-4e00-9a77-2334334b23d3");
        Role role = roleRepo.findById(roleId).orElseThrow(() -> new NotFoundException(String.format("Role not found with id: %s",roleId)));
        user.setRoles(Arrays.asList(role));
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