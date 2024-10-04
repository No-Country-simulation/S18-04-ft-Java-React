package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.PPermission;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.PermissionRepo;
import com.nocountry.nocountry.services.IPermissionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PermissionServiceImpl extends CRUDServiceImpl<PPermission, UUID> implements IPermissionService {

    private final PermissionRepo repo;

    public PermissionServiceImpl(PermissionRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<PPermission, UUID> getRepo() {
        return repo;
    }
}
