package com.sharipov.movie_reservation_system.domain.service;

import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles();
    Profile getProfileById(Long id);
    Profile create(Profile profile);
    Boolean update(Profile profile, Long id);
    void deleteById(Long id);
}
