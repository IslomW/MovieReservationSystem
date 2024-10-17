package com.sharipov.movie_reservation_system.domain.web.controller;


import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.service.ProfileService;
import com.sharipov.movie_reservation_system.domain.web.dto.ProfileDTO;
import com.sharipov.movie_reservation_system.domain.web.mappers.ProfileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileMapper mapper;


    private final ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") Long id) {
        Profile profile = profileService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateProfile(@RequestBody ProfileDTO dto,
                                                 @PathVariable("id") Long id) {

        Profile profile = mapper.profileDTOToEntity(dto);
        Boolean result = profileService.update(profile, id);
        return ResponseEntity.ok(result);

    }


}
