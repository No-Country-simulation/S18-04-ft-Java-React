package com.nocountry.nocountry.services;

import com.nocountry.nocountry.models.Participant;

import java.util.List;
import java.util.UUID;

public interface IParticipantService extends ICRUDService<Participant, UUID> {

    List<Participant> findAllParticipantsByTeamId(String teamId);
}
