package com.nocountry.nocountry.services;

import com.nocountry.nocountry.models.Profile;

import java.util.UUID;

public interface IProfileService extends ICRUDService<Profile, UUID> {

	Profile findProfileByUserId(UUID userId);
}
