package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.TeamMapper;
import com.nocountry.nocountry.dto.request.TeamRequestDTO;
import com.nocountry.nocountry.dto.response.TeamResponseDTO;
import com.nocountry.nocountry.models.Team;
import com.nocountry.nocountry.services.ITeamService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final ITeamService service;
    private final TeamMapper mapper;

    public TeamController(ITeamService service, TeamMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toTeamResponseDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<TeamResponseDTO> save(@Valid @RequestBody TeamRequestDTO dto) {
        Team createdTeam = service.create(mapper.toTeam(dto));
        return ResponseEntity.created(URI.create("/api/teams/" + createdTeam.getId())).body(mapper.toTeamResponseDTO(createdTeam));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> update(@Valid @RequestBody TeamRequestDTO dto, @PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toTeamResponseDTO(service.updateById(mapper.toTeam(dto), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<TeamResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "team_id") String sortField, @RequestParam(defaultValue = "desc") String sortOrder) {

        Page<Team> teamsPage = service.findAllPage(page, size, sortField, sortOrder);
        List<TeamResponseDTO> teamResponseDTOs = teamsPage.getContent()
                .stream()
                .map(mapper::toTeamResponseDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new PageImpl<>(teamResponseDTOs, teamsPage.getPageable(), teamsPage.getTotalElements()), HttpStatus.OK);
    }
}