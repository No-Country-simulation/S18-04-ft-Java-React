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
    TeamResponseDTO toTeamResponseDTO(Team team);

    Team toTeam(TeamRequestDTO dto);
}
