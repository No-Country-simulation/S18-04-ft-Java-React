package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.Role;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.RoleRepo;
import com.nocountry.nocountry.services.IRoleService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleServiceImpl extends CRUDServiceImpl<Role,UUID> implements IRoleService {

    private final RoleRepo repo;

    public RoleServiceImpl(RoleRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<Role, UUID> getRepo() {
        return repo;
    }
}
