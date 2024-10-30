package com.nocountry.nocountry.repository;

import com.nocountry.nocountry.models.Team;
import com.nocountry.nocountry.models.User;
import com.nocountry.nocountry.security.oauth2.user.CurrentUser;
import com.nocountry.nocountry.security.oauth2.user.UserPrincipal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface TeamRepo extends GenericRepo<Team, UUID> {
    @Query(value = "SELECT t.team_id,t.event_record_id,t.meet_url,t.project_name,t.team_name,t.whatsapp_url,team_number FROM event_records e INNER JOIN profiles p ON p.profile_id=e.profile_id INNER JOIN users u ON u.user_id=p.user_id LEFT JOIN teams t ON t.team_id = e.team_id WHERE p.user_id =:userId", nativeQuery = true)
    List<Team> findTeamByProfileId(UUID userId);
}
