package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.ParticipantMapper;
import com.nocountry.nocountry.dto.request.ParticipantRequestDTO;
import com.nocountry.nocountry.dto.response.ParticipantResponseDTO;
import com.nocountry.nocountry.models.Participant;
import com.nocountry.nocountry.services.IParticipantService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    private final IParticipantService service;
    private final ParticipantMapper mapper;

    public ParticipantController(IParticipantService service, ParticipantMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantResponseDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toParticipantDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ParticipantResponseDTO> save(@Valid @RequestBody ParticipantRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toParticipantDTO(service.create(mapper.toParticipant(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipantResponseDTO> update(@Valid @RequestBody ParticipantRequestDTO dto, @PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toParticipantDTO(service.updateById(mapper.toParticipant(dto), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ParticipantResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "participantName") String sortField,
            @RequestParam(defaultValue = "desc") String sortOrder) {
        Page<Participant> participantsPage = service.findAllPage(page, size, sortField, sortOrder);
        List<ParticipantResponseDTO> participantResponseDTOs = participantsPage.getContent()
                .stream()
                .map(mapper::toParticipantDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new PageImpl<>(participantResponseDTOs, participantsPage.getPageable(), participantsPage.getTotalElements()), HttpStatus.OK);
    }

    @GetMapping("/find_all_by_team_id")
    public ResponseEntity<List<ParticipantResponseDTO>> findAllParticipantsByTeamId(
            @RequestBody String teamId ){
        return ResponseEntity.ok(service
                .findAllParticipantsByTeamId(teamId).stream()
                .map(mapper::toParticipantDTO)
                .collect(Collectors.toList()));
    }
}
