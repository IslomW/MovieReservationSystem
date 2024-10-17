package com.sharipov.movie_reservation_system.domain.web.controller;


import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.service.ProfileService;
import com.sharipov.movie_reservation_system.domain.web.dto.ProfileDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {


    private final ProfileService profileService;

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
    public ResponseEntity<Profile> updateProfile(@RequestBody ProfileDTO dto,
                                                 @PathVariable("id") Long id){

        Profile profile =  profileService.update(dto, id);
        return ResponseEntity.ok();

    }


}
