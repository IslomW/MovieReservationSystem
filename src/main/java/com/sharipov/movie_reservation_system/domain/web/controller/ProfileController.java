package com.sharipov.movie_reservation_system.domain.web.controller;


import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.service.ProfileService;
import com.sharipov.movie_reservation_system.domain.web.dto.ProfileDTO;
import com.sharipov.movie_reservation_system.domain.web.mappers.ProfileMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/profile")
@RequiredArgsConstructor
@Tag(
        name = "Profile Controller",
        description = "Profile API"
)
public class ProfileController {

    private final ProfileMapper mapper;


    private final ProfileService profileService;

    //OK
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Get all profiles.(Only Admins)")
    public ResponseEntity<List<ProfileDTO>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        List<ProfileDTO> dtos = mapper.movieListToDTOS(profiles);
        return ResponseEntity.ok(dtos);
    }


    //OK use with token
    @GetMapping("/{id}")
    @Operation(summary = "Get profile by id.")
    public ResponseEntity<ProfileDTO> getProfileById(@PathVariable("id") Long id) {
        Profile profile = profileService.getProfileById(id);
        ProfileDTO dto = mapper.profileEntityToDTO(profile);
        return ResponseEntity.ok(dto);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update profile.")
    public ResponseEntity<Boolean> updateProfile(@RequestBody ProfileDTO dto,
                                                 @PathVariable("id") Long id) {

        Profile profile = mapper.profileDTOToEntity(dto);
        Boolean result = profileService.update(profile, id);
        return ResponseEntity.ok(result);

    }


}
