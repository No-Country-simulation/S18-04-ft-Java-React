package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.EventRecord;
import com.nocountry.nocountry.repository.EventRecordRepo;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.services.IEventRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventRecordServiceImpl extends CRUDServiceImpl<EventRecord, UUID> implements IEventRecordService {

    private final EventRecordRepo repo;

    public EventRecordServiceImpl(EventRecordRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<EventRecord, UUID> getRepo() {
        return repo;
    }

    @Override
    public List<EventRecord> findAllEventRecordsByUserId(String userId) {
        return repo.findAll().stream()
                .filter(e -> e.getProfile().getUser().getId().toString().equals(userId)).toList();
    }

    @Override
    public List<EventRecord> findAllByRegister(String schedule, UUID roleTypeId,
                                               UUID languageId, UUID eventId, UUID frameworkId){
        return repo.findAllByRegister(schedule, roleTypeId, languageId, eventId, frameworkId);
    }
}
