package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.TechnologyMapper;
import com.nocountry.nocountry.dto.response.TechnologyResponseDTO;
import com.nocountry.nocountry.services.ITechnologyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
    private final ITechnologyService service;
    private final TechnologyMapper mapper;

    public TechnologyController(ITechnologyService service, TechnologyMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponseDTO>> findAll() {
        return ResponseEntity.ok(service.getAll().stream()
                .map(mapper::toTechnologyResponseDTO)
                .collect(Collectors.toList()));
    }

}