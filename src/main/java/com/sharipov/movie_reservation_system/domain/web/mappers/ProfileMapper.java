package com.sharipov.movie_reservation_system.domain.web.mappers;

import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.web.dto.MovieDTO;
import com.sharipov.movie_reservation_system.domain.web.dto.ProfileDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProfileMapper {
    public Profile profileDTOToEntity(ProfileDTO dto) {
        Profile profile = new Profile();
        profile.setName(dto.getName());
        profile.setUsername(dto.getUsername());
        profile.setPassword(dto.getPassword());
        profile.setRole(dto.getRole());
        return profile;
    }

    public static ProfileDTO profileEntityToDTO(Profile profile) {
        ProfileDTO dto = new ProfileDTO();
        dto.setName(profile.getName());
        dto.setUsername(profile.getUsername());
        dto.setPassword(profile.getPassword());
        dto.setRole(profile.getRole());
        return dto;
    }

    public List<ProfileDTO> movieListToDTOS(List<Profile> profiles){
        return profiles.stream()
                .map(ProfileMapper::profileEntityToDTO)
                .collect(Collectors.toList());
    }
}
