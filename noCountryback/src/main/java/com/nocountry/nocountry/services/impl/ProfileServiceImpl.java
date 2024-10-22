package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.config.mapper.ProfileMapper;
import com.nocountry.nocountry.dto.request.ProfileRequestDTO;
import com.nocountry.nocountry.dto.response.ProfileResponseDTO;
import com.nocountry.nocountry.exceptions.BadRequestException;
import com.nocountry.nocountry.exceptions.NotFoundException;
import com.nocountry.nocountry.models.Profile;
import com.nocountry.nocountry.models.User;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.ProfileRepo;
import com.nocountry.nocountry.repository.UserRepo;
import com.nocountry.nocountry.security.oauth2.user.UserPrincipal;
import com.nocountry.nocountry.services.IEmailService;
import com.nocountry.nocountry.services.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileServiceImpl extends CRUDServiceImpl<Profile, UUID> implements IProfileService {
    private final IEmailService emailService;
    private final ProfileRepo repo;
    private final ProfileMapper mapper;
    private final UserRepo userRepo;

    public ProfileServiceImpl(IEmailService emailService, ProfileRepo repo, ProfileMapper mapper, UserRepo userRepo) {
        this.emailService = emailService;
        this.repo = repo;
        this.mapper = mapper;
        this.userRepo = userRepo;
    }

    @Override
    protected GenericRepo<Profile, UUID> getRepo() {
        return repo;
    }

    @Override
    public Profile findProfileByUserId( UUID userId ) {
        return repo.findProfileByUserId( userId ).orElseThrow(() -> new NotFoundException( "Profile not found" ) );
    }

    @Override
    public ProfileResponseDTO createProfile(ProfileRequestDTO dto, UserPrincipal userPrincipal) {
        Optional<User> userFound = userRepo.findByEmail(userPrincipal.getEmail());
        if (userFound.isEmpty()) {
            throw new BadRequestException("User not found");
        }
        Profile profile = mapper.toProfile(dto);
        profile.setUser(userFound.get());
        Profile savedProfile = repo.save(profile);
        emailService.registerConfirmation(savedProfile.getUser().getEmail());
        return mapper.toProfileResponseDTO(savedProfile);
    }

}
