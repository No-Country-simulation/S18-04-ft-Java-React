package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.UserRequestDTO;
import com.nocountry.nocountry.dto.response.UserResponseDTO;
import com.nocountry.nocountry.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", source = "password") // Mapeo explícito del password
    UserResponseDTO toUserResponseDTO(User user);

    User toUser(UserRequestDTO dto);
}
