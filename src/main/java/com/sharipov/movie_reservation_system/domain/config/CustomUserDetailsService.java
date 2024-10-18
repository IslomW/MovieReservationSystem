package com.sharipov.movie_reservation_system.domain.config;

import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final ProfileRepository profileRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Profile>optional = profileRepository.findByUsername(username);
        log.info(optional.toString());

        if (optional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        Profile profile = optional.get();
        log.info(profile.toString());
        CustomUserDetails userDetails = new CustomUserDetails(profile);


        return userDetails;
    }
}
