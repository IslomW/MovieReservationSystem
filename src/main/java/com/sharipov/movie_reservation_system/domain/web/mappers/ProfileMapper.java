package com.sharipov.movie_reservation_system.domain.web.mappers;

import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.web.dto.ProfileDTO;
import org.springframework.stereotype.Component;


@Component
public class ProfileMapper {
    public Profile profileDTOToEntity(ProfileDTO dto) {
        Profile profile = new Profile();
        profile.setName(dto.getName());
        profile.setUsername(dto.getUsername());
        profile.setPassword(dto.getPassword());
        profile.setConfirmationPassword(dto.getConfirmationPassword());
        return profile;
    }

    public ProfileDTO profileEntityToDTO(Profile profile) {
        ProfileDTO dto = new ProfileDTO();
        dto.setName(profile.getName());
        dto.setUsername(profile.getUsername());
        dto.setPassword(profile.getPassword());
        dto.setConfirmationPassword(profile.getConfirmationPassword());
        return dto;
    }
}
