package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.ProfileMapper;
import com.nocountry.nocountry.dto.request.ProfileRequestDTO;
import com.nocountry.nocountry.dto.response.ProfileResponseDTO;
import com.nocountry.nocountry.models.Profile;
import com.nocountry.nocountry.services.IProfileService;
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
@RequestMapping("/api/profiles")
public class ProfileController {

    private final IProfileService service;
    private final ProfileMapper mapper;

    public ProfileController(IProfileService service, ProfileMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponseDTO> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toProfileResponseDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> save(@Valid @RequestBody ProfileRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toProfileResponseDTO(service.create(mapper.toProfile(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileResponseDTO> update(@Valid @RequestBody ProfileRequestDTO dto, @PathVariable("id") UUID id) {
        return ResponseEntity.ok(mapper.toProfileResponseDTO(service.updateById(mapper.toProfile(dto), id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ProfileResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "profileName") String sortField,
            @RequestParam(defaultValue = "desc") String sortOrder) {
        Page<Profile> profilesPage = service.findAllPage(page, size, sortField, sortOrder);
        List<ProfileResponseDTO> profileResponseDTOs = profilesPage.getContent()
                .stream()
                .map(mapper::toProfileResponseDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new PageImpl<>(profileResponseDTOs, profilesPage.getPageable(), profilesPage.getTotalElements()), HttpStatus.OK);
    }
}
