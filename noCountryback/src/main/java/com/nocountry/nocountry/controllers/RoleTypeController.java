package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.RoleTypeMapper;
import com.nocountry.nocountry.dto.response.RoleTypeResponseDTO;
import com.nocountry.nocountry.services.IRoleTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/role-types")
public class RoleTypeController {

    private final IRoleTypeService service;
    private final RoleTypeMapper mapper;

    public RoleTypeController(IRoleTypeService service, RoleTypeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<RoleTypeResponseDTO>> findAll() {
        return ResponseEntity.ok(service.getAll().stream()
                .map(mapper::toRoleTypeResponseDTO)
                .collect(Collectors.toList()));
    }
}
