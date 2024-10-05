package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.ProfileRequestDTO;
import com.nocountry.nocountry.dto.response.ProfileResponseDTO;
import com.nocountry.nocountry.models.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    @Mapping(source = "profileName", target = "profileName")
    @Mapping(source = "profileLastname", target = "profileLastname")
    @Mapping(source = "githubUrl", target = "githubUrl")
    @Mapping(source = "linkedinUrl", target = "linkedinUrl")
    @Mapping(source = "avatarUrl", target = "avatarUrl")
    @Mapping(source = "user", target = "user")
    ProfileResponseDTO toProfileResponseDTO(Profile profile);

    @Mapping(source = "profileName", target = "profileName")
    @Mapping(source = "profileLastname", target = "profileLastname")
    @Mapping(source = "githubUrl", target = "githubUrl")
    @Mapping(source = "linkedinUrl", target = "linkedinUrl")
    @Mapping(source = "avatarUrl", target = "avatarUrl")
    @Mapping(source = "user", target = "user")
    Profile toProfile(ProfileRequestDTO dto);
}
