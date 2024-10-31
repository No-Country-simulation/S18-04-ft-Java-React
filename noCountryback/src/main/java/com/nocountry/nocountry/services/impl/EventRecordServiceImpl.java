package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.exceptions.BadRequestException;
import com.nocountry.nocountry.exceptions.NotFoundException;
import com.nocountry.nocountry.models.Event;
import com.nocountry.nocountry.models.EventRecord;
import com.nocountry.nocountry.models.Profile;
import com.nocountry.nocountry.repository.EventRecordRepo;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.ProfileRepo;
import com.nocountry.nocountry.services.IEventRecordService;
import com.nocountry.nocountry.utils.CookieUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class EventRecordServiceImpl extends CRUDServiceImpl<EventRecord, UUID> implements IEventRecordService {

    private final EventRecordRepo repo;
    private final ProfileRepo profileRepo;
    public EventRecordServiceImpl(EventRecordRepo repo, ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
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
    public EventRecord createDos( EventRecord eventRecord, HttpServletRequest resp, UUID userId ) {
        log.info( "-----------------------> Funcion createDOs");
        Profile profile = profileRepo.findProfileByUserId( userId ).orElseThrow(() -> new NotFoundException( "Profile not found" ) );
        Event event = new Event();
        Optional<Cookie> idProject = CookieUtils.getCookie( resp,"id-project" );
        if( idProject.isEmpty() ) throw new BadRequestException("id-project not found");
        log.info( "-----------------------> id-project: {}", idProject.get().getValue() );
        event.setId( UUID.fromString( idProject.get().getValue() ) );
        eventRecord.setProfile( profile );
        eventRecord.setEvent( event );
        repo.save( eventRecord );
        return eventRecord;
    }

    @Override
    public List<EventRecord> findEventRecordByUser(UUID userId) {
        return repo.findEventRecordByUser(userId);
    }
}
