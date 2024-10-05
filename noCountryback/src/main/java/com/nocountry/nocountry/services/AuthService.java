package com.nocountry.nocountry.services;

import com.nocountry.nocountry.dto.request.LoginRequestDTO;
import com.nocountry.nocountry.dto.request.RegisterRequestDTO;
import com.nocountry.nocountry.dto.response.AuthResponseDTO;

public interface AuthService {

    AuthResponseDTO login(LoginRequestDTO dto);
    AuthResponseDTO register(RegisterRequestDTO dto);
    AuthResponseDTO getUserByUsername(String username);


}
