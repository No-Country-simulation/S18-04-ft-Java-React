package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.Team;
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
    public List<Team> findTeamByProfileId(UUID userId) {
        return repo.findTeamByProfileId(userId) ;
    }
}
