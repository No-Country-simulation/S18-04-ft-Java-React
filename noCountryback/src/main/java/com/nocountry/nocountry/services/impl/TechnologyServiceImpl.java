package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.Technology;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.TechnologyRepo;
import com.nocountry.nocountry.services.ITechnologyService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TechnologyServiceImpl extends CRUDServiceImpl<Technology, UUID> implements ITechnologyService {

    private final TechnologyRepo repo;

    public TechnologyServiceImpl(TechnologyRepo repo) {
        this.repo=repo;
    }

    @Override
    protected GenericRepo<Technology, UUID> getRepo() {
        return repo;
    }
}
