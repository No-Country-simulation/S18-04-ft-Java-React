package com.nocountry.nocountry.repository;

import com.nocountry.nocountry.models.EventRecord;
import com.nocountry.nocountry.models.Team;
import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "SELECT e.event_record_id,e.team_id,e.assigned,e.number_team,e.profile_id,e.tl,e.schedule,e.language_id,e.event_id,e.role_type_id FROM event_records e WHERE e.team_id =:teamId",nativeQuery = true)
    List<EventRecord>findEventRecordByTeam(@Param("teamId") UUID teamId);

    @Query(value = "SELECT  e.event_record_id,e.team_id,e.assigned,e.number_team,e.profile_id,e.tl,e.schedule,e.language_id,e.event_id,e.role_type_id FROM event_records e LEFT JOIN profiles p ON p.profile_id = e.profile_id LEFT JOIN users u ON u.user_id = p.user_id WHERE u.user_id =:userId",nativeQuery = true)
    List<EventRecord>findEventRecordByUser(@Param("userId") UUID userId);
}
