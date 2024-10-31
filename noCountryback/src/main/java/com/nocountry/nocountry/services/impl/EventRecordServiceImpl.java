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

//    @Override
//    public List<EventRecord> findAllEventByUserId(String userId) {
//        return repo.findAll().stream()
//                .filter(e -> e.getParticipants().stream()
//                        .anyMatch(p -> p.getId().toString().equals(userId)) ).toList();
//    }

    @Override
    public void updateAssignedRecords(UUID eventNum, String scheduleNom, String frameworkFront,
                                      int frontQuantity, int backQuantity, int qaQuantity,
                                      int pmQuantity, int uxQuantity) {
        repo.callUpdateAssignedRecords(eventNum, scheduleNom, frameworkFront,
                frontQuantity, backQuantity, qaQuantity,
                pmQuantity, uxQuantity);
    }

    @Override
    public void register_participants_in_teams(UUID eventId, String eventName) {
        repo.callCreateTeamsAndParticipants(eventId, eventName);
    }

    @Override
    public List<EventRecord> findEventRecordByTeam(UUID teamId) {
        return repo.findEventRecordByTeam(teamId);
    }

    @Override
    public List<EventRecord> findEventRecordByUser(UUID userId) {
        return repo.findEventRecordByUser(userId);
    }
}
