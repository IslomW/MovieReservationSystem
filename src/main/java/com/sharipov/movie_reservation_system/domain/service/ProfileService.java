package com.sharipov.movie_reservation_system.domain.service;

import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.web.dto.AuthDTO;
import com.sharipov.movie_reservation_system.domain.web.dto.ProfileDTO;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles();
    Profile getProfileById(Long id);
    ProfileDTO create(ProfileDTO profileDTO);
    Boolean update(Profile profile, Long id);

    ProfileDTO authorization(AuthDTO dto);
    void deleteById(Long id);
}
