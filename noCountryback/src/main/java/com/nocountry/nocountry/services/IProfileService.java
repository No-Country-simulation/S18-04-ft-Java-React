package com.nocountry.nocountry.services;

import com.nocountry.nocountry.dto.request.ProfileRequestDTO;
import com.nocountry.nocountry.dto.response.ProfileResponseDTO;
import com.nocountry.nocountry.models.Profile;
import com.nocountry.nocountry.security.oauth2.user.UserPrincipal;

import java.util.UUID;

public interface IProfileService extends ICRUDService<Profile, UUID> {

	Profile findProfileByUserId(UUID userId);
	ProfileResponseDTO createProfile(ProfileRequestDTO dto, UserPrincipal userPrincipal);
}
