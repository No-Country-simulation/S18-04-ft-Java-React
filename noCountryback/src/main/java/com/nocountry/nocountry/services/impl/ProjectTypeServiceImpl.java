package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.ProjectType;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.ProjectTypeRepo;
import com.nocountry.nocountry.services.IProjectTypeService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProjectTypeServiceImpl  extends CRUDServiceImpl<ProjectType, UUID> implements IProjectTypeService {
    private final ProjectTypeRepo repo;

    public ProjectTypeServiceImpl(ProjectTypeRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<ProjectType, UUID> getRepo() {
        return repo;
    }
}
