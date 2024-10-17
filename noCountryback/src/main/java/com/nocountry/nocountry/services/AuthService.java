package com.nocountry.nocountry.services;

import com.nocountry.nocountry.dto.request.LoginRequestDTO;
import com.nocountry.nocountry.dto.request.RegisterRequestDTO;
import com.nocountry.nocountry.dto.response.UserResponseDTO;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

//    AuthResponseDTO login(LoginRequestDTO dto, HttpServletResponse response);
    UserResponseDTO login(LoginRequestDTO dto, HttpServletResponse response);
    UserResponseDTO register(RegisterRequestDTO dto, HttpServletResponse response);
    UserResponseDTO getUserByUsername(String username,HttpServletResponse response );


}
