package com.nocountry.nocountry.services;

import com.nocountry.nocountry.models.Profile;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface IProfileService extends ICRUDService<Profile, UUID> {

	Profile findProfileByUserId(UUID userId);
}
