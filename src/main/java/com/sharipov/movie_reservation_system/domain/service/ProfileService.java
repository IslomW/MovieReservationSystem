package com.sharipov.movie_reservation_system.domain.service;

import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> getAllUsersByUserName(String username);
    Profile getUserById(Long id);
    Profile create(Profile profile);
    Boolean update(Profile profile);
    void deleteById(Long id);
}
