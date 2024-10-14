package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.Session;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.SessionRepo;
import com.nocountry.nocountry.services.ISessionService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionServiceImpl extends CRUDServiceImpl<Session, UUID> implements ISessionService {

    private final SessionRepo repo;

    public SessionServiceImpl(SessionRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<Session, UUID> getRepo() {
        return repo;
    }
}
