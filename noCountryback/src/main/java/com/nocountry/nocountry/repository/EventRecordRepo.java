package com.nocountry.nocountry.repository;

import com.nocountry.nocountry.models.EventRecord;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EventRecordRepo extends GenericRepo<EventRecord, UUID> {

    @Procedure(procedureName = "UpdateAssignedRecords")
    void callUpdateAssignedRecords(
            @Param("eventNum") UUID eventNum,
            @Param("scheduleNom") String scheduleNom,
            @Param("frameworkFront") String frameworkFront,
            @Param("frontQuantity") Integer frontQuantity,
            @Param("backQuantity") Integer backQuantity,
            @Param("qaQuantity") Integer qaQuantity,
            @Param("pmQuantity") Integer pmQuantity,
            @Param("uxQuantity") Integer uxQuantity
    );

    @Procedure(procedureName = "create_teams_and_participants")
    void callCreateTeamsAndParticipants(
            @Param("event_pk") UUID event_pk,
            @Param("team_init") String team_init
    );
}
