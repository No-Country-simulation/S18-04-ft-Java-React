package com.nocountry.nocountry.services;

import com.nocountry.nocountry.models.*;

import java.util.UUID;

public interface ITeamService extends ICRUDService<Team, UUID> {

    void addParticipant(UUID teamId, Participant participant);
    void addFramework(UUID teamId, Framework framework);
    void addLanguage(UUID teamId, Technology technology);
}
