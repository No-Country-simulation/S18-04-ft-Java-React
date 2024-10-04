package com.nocountry.nocountry.dto.request;

import com.nocountry.nocountry.dto.response.UserResponseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class ProfileRequestDTO {
    private UUID id;
    private String profileName;
    private String profileLastname;
    private String githubUrl;
    private String linkedinUrl;
    private String avatarUrl;
    private UserResponseDTO user;
}
