package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.ProfileRequestDTO;
import com.nocountry.nocountry.dto.response.ProfileResponseDTO;
import com.nocountry.nocountry.models.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.email", target = "email")
    ProfileResponseDTO toProfileResponseDTO(Profile profile);

    @Mapping(source = "user", target = "user")
    Profile toProfile(ProfileRequestDTO dto);
}
