package com.sharipov.movie_reservation_system.domain.service.impl;

import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.exception.ResourceNotFoundException;
import com.sharipov.movie_reservation_system.domain.repository.ProfileRepository;
import com.sharipov.movie_reservation_system.domain.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public List<Profile> getAllProfilesByUserName(String username) {
        List<Profile> profiles = (List<Profile>) profileRepository.findAll();
        return profiles;
    }

    @Override
    public Profile getProfileById(Long id) {
        Profile profile = profileRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User Not Found"));
        return profile;
    }

    @Override
    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Boolean update(Profile profile, Long id) {
        Profile exist = getProfileById(id);
        if (exist.equals(null)){
            throw new ResourceNotFoundException("Profile not found.");
        }
        profileRepository.save(exist);
        return true;
    }

    @Override
    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }
}
