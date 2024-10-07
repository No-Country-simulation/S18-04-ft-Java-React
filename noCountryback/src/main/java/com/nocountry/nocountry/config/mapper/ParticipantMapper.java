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
    @Mapping(source = "team", target = "team")
    @Mapping(source = "buddy", target = "buddy")
    @Mapping(source = "sessions", target = "sessions")
    Participant toParticipant(ParticipantRequestDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "isTl", target = "isTl")
    @Mapping(source = "team.teamName", target = "teamName")
    @Mapping(source = "team.projectName", target = "projectName")
    @Mapping(source = "eventRecord.profile.profileLastname", target = "participantLastname")
    @Mapping(source = "eventRecord.profile.profileLastname", target = "participantName")
    @Mapping(source = "team.tl.eventRecord.profile.profileLastname", target = "tlLastname")
    @Mapping(source = "team.tl.eventRecord.profile.profileLastname", target = "tlName")
    @Mapping(source = "buddy", target = "buddy")
    @Mapping(source = "sessions", target = "sessions")
    ParticipantResponseDTO toParticipantDTO(Participant participant);
}