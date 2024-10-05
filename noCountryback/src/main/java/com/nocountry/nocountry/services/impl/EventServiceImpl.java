package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.Event;
import com.nocountry.nocountry.repository.EventRepo;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.services.IEventService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventServiceImpl extends CRUDServiceImpl<Event, UUID> implements IEventService {

    private final EventRepo repo;

    public EventServiceImpl(EventRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<Event, UUID> getRepo() {
        return repo;
    }
}
