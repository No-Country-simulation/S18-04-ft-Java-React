package com.nocountry.nocountry.repository;

import com.nocountry.nocountry.models.RoleType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RoleTypeRepo extends GenericRepo<RoleType, UUID> {

    @Query(value = "SELECT r.role_type_id,r.role_type_name,r.project_type_id FROM roles_type r WHERE r.project_type_id =:projectType", nativeQuery = true)
    List<RoleType> findAllByProjectType(@Param("projectType") UUID projectType);
}
