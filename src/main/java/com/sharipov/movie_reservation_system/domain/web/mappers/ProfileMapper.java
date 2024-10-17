package com.sharipov.movie_reservation_system.domain.web.mappers;

import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.web.dto.ProfileDTO;

public class ProfileMapper {
    public Profile profileDTOToEntity(ProfileDTO dto){
        Profile profile = new Profile();
        profile.setName();
        profile.setUsername();
        profile.setPassword();






           profile.setConfirmationPassword();



            return profile;
    }
}
