package com.nocountry.nocountry.config.mapper;


import com.nocountry.nocountry.dto.request.ParticipantRequestDTO;
import com.nocountry.nocountry.dto.response.ParticipantResponseDTO;
import com.nocountry.nocountry.models.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {

    ParticipantMapper INSTANCE = Mappers.getMapper(ParticipantMapper.class);

    @Mapping(source = "isTl", target = "isTl")
    @Mapping(source = "team", target = "team") // Mapea el TeamResponseDTO al equipo
    @Mapping(source = "participants", target = "participants") // Mapea la lista de encuestas
    @Mapping(source = "buddy", target = "buddy") // Mapea la lista de compañeros
    @Mapping(source = "sessions", target = "sessions") // Mapea la lista de sesiones
    Participant toParticipant(ParticipantRequestDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "isTl", target = "isTl")
    @Mapping(source = "team", target = "team")
    @Mapping(source = "participants", target = "participants")
    @Mapping(source = "buddy", target = "buddy")
    @Mapping(source = "sessions", target = "sessions")
    ParticipantResponseDTO toParticipantDTO(Participant participant);
}