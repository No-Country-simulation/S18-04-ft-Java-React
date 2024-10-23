package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.exceptions.NotFoundException;
import com.nocountry.nocountry.models.*;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.TeamRepo;
import com.nocountry.nocountry.services.ITeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeamServiceImpl extends CRUDServiceImpl<Team, UUID>  implements ITeamService {

    private final TeamRepo repo;

    public TeamServiceImpl(TeamRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<Team, UUID> getRepo() {
        return repo;
    }

    @Override
    public void addParticipant(UUID teamId, Participant participant) {
        Team team = repo.findById(teamId).orElseThrow(() -> new NotFoundException("ID NOT FOUND: " + teamId));
        List<Participant> participants = team.getParticipants();
        participants.add(participant);
        team.setParticipants(participants);
        repo.updateById(team, teamId);
    }

    @Override
    public void addFramework(UUID teamId, Framework framework) {
        Team team = repo.findById(teamId).orElseThrow(() -> new NotFoundException("ID NOT FOUND: " + teamId));
        List<Framework> frameworks = team.getTeamFrameworks();
        frameworks.add(framework);
        team.setTeamFrameworks(frameworks);
        repo.updateById(team, teamId);
    }

    @Override
    public void addLanguage(UUID teamId, Technology technology) {
        Team team = repo.findById(teamId).orElseThrow(() -> new NotFoundException("ID NOT FOUND: " + teamId));
        List<Technology> technologies = team.getTechnologies();
        technologies.add(technology);
        team.setTechnologies(technologies);
        repo.updateById(team, teamId);
    }

}
