package com.nocountry.nocountry.repository;

import com.nocountry.nocountry.models.Profile;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepo extends GenericRepo<Profile, UUID> {

	@Query(value = "SELECT p FROM Profile p WHERE p.user.id = ?1")
	Optional<Profile> findProfileByUserId( UUID userId);
}
