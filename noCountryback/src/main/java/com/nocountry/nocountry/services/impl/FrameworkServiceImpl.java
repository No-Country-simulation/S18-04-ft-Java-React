package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.Framework;
import com.nocountry.nocountry.repository.FrameworkRepo;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.services.IFrameworkService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FrameworkServiceImpl extends CRUDServiceImpl<Framework, UUID> implements IFrameworkService {

    private final FrameworkRepo repo;

    public FrameworkServiceImpl(FrameworkRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<Framework, UUID> getRepo() {
        return repo;
    }
}
