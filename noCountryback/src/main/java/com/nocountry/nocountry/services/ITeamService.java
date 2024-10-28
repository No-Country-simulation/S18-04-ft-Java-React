package com.nocountry.nocountry.services;

import com.nocountry.nocountry.models.Team;

import java.util.List;
import java.util.UUID;

public interface ITeamService extends ICRUDService<Team, UUID> {
    List<Team> findTeamByProfileId(UUID userId);
}
