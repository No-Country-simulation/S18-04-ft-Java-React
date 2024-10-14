package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.FrameworkMapper;
import com.nocountry.nocountry.dto.response.FrameworkResponseDTO;
import com.nocountry.nocountry.services.IFrameworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/frameworks")
public class FrameworksController {

    private final IFrameworkService service;
    private final FrameworkMapper mapper;

    public FrameworksController(IFrameworkService service, FrameworkMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<FrameworkResponseDTO>> findAll() {
        return ResponseEntity.ok(service.getAll().stream()
                .map(mapper::toFrameworkDTO)
                .collect(Collectors.toList()));
    }
}
