package com.nocountry.nocountry.config.mapper;

import com.nocountry.nocountry.dto.request.TeamRequestDTO;
import com.nocountry.nocountry.dto.response.TeamResponseDTO;
import com.nocountry.nocountry.models.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    @Mapping(source = "teamFrameworks", target = "teamFrameworks")
    @Mapping(source = "technologies", target = "technologies")
    @Mapping(source = "tl.id",target = "tlId")
    @Mapping(source = "tl.profile.profileName",target = "tlName")
    @Mapping(source = "tl.profile.profileLastname",target = "tlLastname")
    TeamResponseDTO toTeamResponseDTO(Team team);

    @Mapping(source = "teamFrameworks",target = "teamFrameworks")
    @Mapping(source = "technologies",target = "technologies")
    @Mapping(source = "tl",target = "tl.id")
    @Mapping(source = "participants",target = "participants")
    Team toTeam(TeamRequestDTO dto);
}
