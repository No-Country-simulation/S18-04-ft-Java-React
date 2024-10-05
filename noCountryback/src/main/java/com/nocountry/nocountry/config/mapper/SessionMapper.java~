package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.SessionRequestDTO;
import com.nocountry.nocountry.dto.response.SessionResponseDTO;
import com.nocountry.nocountry.models.Session;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    @Mapping(source = "participant", target = "participant")
    SessionResponseDTO toSessionResponseDTO(Session session);

    @Mapping(source = "participantId", target = "participant.id")
    Session toSession(SessionRequestDTO dto);
}
