package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.Participant;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.ParticipantRepo;
import com.nocountry.nocountry.services.IParticipantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantServiceImpl extends CRUDServiceImpl<Participant, UUID> implements IParticipantService {

    private final ParticipantRepo repo;

    public ParticipantServiceImpl(ParticipantRepo repo) {
        this.repo = repo;
    }


    @Override
    protected GenericRepo<Participant, UUID> getRepo() {
        return null;
    }

    @Override
    public List<Participant> findAllParticipantsByTeamId(String teamId) {
        return repo.findAll().stream()
                .filter(p -> p.getTeam().getId().toString().equals(teamId)).toList();
    }
}
