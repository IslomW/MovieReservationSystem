package com.sharipov.movie_reservation_system.domain.service.impl;

import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProfileServiceImpl implements ProfileService {
    @Override
    public List<Profile> getAllUsersByUserName(String username) {
        return null;
    }

    @Override
    public Profile getUserById(Long id) {
        return null;
    }

    @Override
    public Profile create(Profile profile) {
        return null;
    }

    @Override
    public Boolean update(Profile profile) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
