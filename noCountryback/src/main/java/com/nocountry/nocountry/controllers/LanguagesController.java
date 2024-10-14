package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.LanguagesMapper;
import com.nocountry.nocountry.dto.response.LanguagesResponseDTO;
import com.nocountry.nocountry.services.ILanguagesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private final ILanguagesService service;
    private final LanguagesMapper mapper;

    public LanguagesController(ILanguagesService  service, LanguagesMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<LanguagesResponseDTO>> findAll() {
        return ResponseEntity.ok(service.getAll().stream()
                .map(mapper::toLanguagesResponseDTO)
                .collect(Collectors.toList()));
    }
}
