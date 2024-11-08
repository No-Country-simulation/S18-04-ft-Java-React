package com.nocountry.nocountry.services.impl;

import com.nocountry.nocountry.models.RoleType;
import com.nocountry.nocountry.repository.GenericRepo;
import com.nocountry.nocountry.repository.RoleTypeRepo;
import com.nocountry.nocountry.services.IRoleTypeService;
import com.nocountry.nocountry.utils.CookieUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleTypeServiceImpl extends CRUDServiceImpl<RoleType, UUID> implements IRoleTypeService {
    private final RoleTypeRepo repo;

    public RoleTypeServiceImpl(RoleTypeRepo repo) {
        this.repo = repo;
    }

    @Override
    protected GenericRepo<RoleType, UUID> getRepo() {
        return repo;
    }

    @Override
    public List<RoleType> findAllByProjectType( UUID projectTypeId, HttpServletResponse resp ) {
        var lista = repo.findAllByProjectType(projectTypeId);
        CookieUtils.addCookie( resp, "id-project", projectTypeId.toString(), 3600 );
        return lista;
    }
}
