package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.ProjectTypeMapper;
import com.nocountry.nocountry.dto.response.ProjectTypeResponseDTO;
import com.nocountry.nocountry.services.IProjectTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/project-types")
public class ProjectTypeController {

    private final IProjectTypeService service;
    private final ProjectTypeMapper mapper;

    public ProjectTypeController(IProjectTypeService service, ProjectTypeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ProjectTypeResponseDTO>> findAll() {
        return ResponseEntity.ok(service.getAll().stream()
                .map(mapper::toProjectTypeResponseDTO)
                .collect(Collectors.toList()));
    }
}
