package com.nocountry.nocountry.dto.response;

import com.nocountry.nocountry.models.User;

import java.util.UUID;

public record ProfileResponseDTO(
        UUID id,
        String profileName,
        String profileLastname,
        String githubUrl,
        String linkedinUrl,
        String avatarUrl,
        String userId,
        String email
) {
}
