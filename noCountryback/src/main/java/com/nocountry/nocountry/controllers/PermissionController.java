package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.PermissionMapper;
import com.nocountry.nocountry.dto.response.PermissionResponseDTO;
import com.nocountry.nocountry.services.IPermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {
    private final IPermissionService service;
    private final PermissionMapper mapper;

    public PermissionController(IPermissionService service, PermissionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<PermissionResponseDTO>> findAll() {
        return ResponseEntity.ok(service.getAll().stream()
                .map(mapper::toPermissionResponseDTO)
                .collect(Collectors.toList()));
    }
}