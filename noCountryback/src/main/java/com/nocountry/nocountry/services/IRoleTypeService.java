package com.nocountry.nocountry.services;

import com.nocountry.nocountry.models.ProjectType;
import com.nocountry.nocountry.models.RoleType;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.UUID;

public interface IRoleTypeService extends ICRUDService<RoleType, UUID> {
    List<RoleType> findAllByProjectType( UUID projectTypeId, HttpServletResponse resp );
}
