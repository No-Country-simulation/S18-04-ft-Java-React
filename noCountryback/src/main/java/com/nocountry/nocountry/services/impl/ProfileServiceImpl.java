package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.exceptions.NotFoundException;
import com.nocountry.nocountry.models.Profile;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.ProfileRepo;
import com.nocountry.nocountry.services.IProfileService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileServiceImpl extends CRUDServiceImpl<Profile, UUID> implements IProfileService {

    private final ProfileRepo repo;

    public ProfileServiceImpl(ProfileRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<Profile, UUID> getRepo() {
        return repo;
    }

    @Override
    public Profile findProfileByUserId( UUID userId ) {
        Profile profile = repo.findProfileByUserId( userId ).orElseThrow(() -> new NotFoundException( "Profile not found" ) );
        return profile;
    }
}
