package com.nocountry.nocountry.controllers;

import com.nocountry.nocountry.config.mapper.ProfileMapper;
import com.nocountry.nocountry.dto.request.ProfileRequestDTO;
import com.nocountry.nocountry.dto.response.EventResponseDTO;
import com.nocountry.nocountry.dto.response.ProfileResponseDTO;
import com.nocountry.nocountry.models.Profile;
import com.nocountry.nocountry.security.oauth2.user.CurrentUser;
import com.nocountry.nocountry.security.oauth2.user.UserPrincipal;
import com.nocountry.nocountry.services.IProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final IProfileService service;
    private final ProfileMapper mapper;

    @GetMapping()
    public ResponseEntity<ProfileResponseDTO> findById( @CurrentUser UserPrincipal userPrincipal ) {
        log.info("Current user Profile findById{}", userPrincipal.getName());
        return ResponseEntity.ok(mapper.toProfileResponseDTO(service.findProfileByUserId(userPrincipal.getId())));
    }

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> save(@Valid @RequestBody ProfileRequestDTO dto, @CurrentUser UserPrincipal userPrincipal) {
        log.info("Current user Profile Save{}", userPrincipal.getName());
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
        List<ProfileResponseDTO> list = service.findAllPage(page,size,sortField,sortOrder).stream().map(mapper::toProfileResponseDTO).collect(Collectors.toList());
        Page<ProfileResponseDTO> listResponse = new PageImpl<>(list);
        return new ResponseEntity<>(listResponse, HttpStatus.OK);
    }
}
