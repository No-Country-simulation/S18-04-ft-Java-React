package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.RoleType;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.RoleTypeRepo;
import com.nocountry.nocountry.services.IRoleTypeService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleTypeServiceImpl extends CRUDServiceImpl<RoleType, UUID> implements IRoleTypeService {
    private final RoleTypeRepo repo;

    public RoleTypeServiceImpl(RoleTypeRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<RoleType, UUID> getRepo() {
        return repo;
    }
}
