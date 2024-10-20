package com.sharipov.movie_reservation_system.domain.service.impl;

import com.sharipov.movie_reservation_system.domain.config.CustomUserDetails;
import com.sharipov.movie_reservation_system.domain.entity.profile.GeneralStatus;
import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.entity.profile.Role;
import com.sharipov.movie_reservation_system.domain.exception.BadAppRequestException;
import com.sharipov.movie_reservation_system.domain.exception.ResourceNotFoundException;
import com.sharipov.movie_reservation_system.domain.repository.ProfileRepository;
import com.sharipov.movie_reservation_system.domain.service.ProfileService;
import com.sharipov.movie_reservation_system.domain.util.JwtUtil;
import com.sharipov.movie_reservation_system.domain.web.dto.AuthDTO;
import com.sharipov.movie_reservation_system.domain.web.dto.ProfileDTO;
import com.sharipov.movie_reservation_system.domain.web.mappers.ProfileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class ProfileServiceImpl implements ProfileService {
    private final ProfileMapper mapper;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;

    private final ProfileRepository profileRepository;

    @Override
    public List<Profile> getAllProfiles() {
        List<Profile> profiles = (List<Profile>) profileRepository.findAll();
        return profiles;
    }

    @Override
    public Profile getProfileById(Long id) {
        log.info(id.toString());
        Profile profile = profileRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User Not Found"));
        return profile;
    }

    @Override
    public ProfileDTO create(ProfileDTO profileDTO) {

        Profile profile = mapper.profileDTOToEntity(profileDTO);

        if (!profileDTO.getPassword().equals(profileDTO.getConfirmationPassword())) {
            throw new BadAppRequestException("Password and PasswordConfirmation dont match.");
        }
        profile.setPassword(encoder.encode(profileDTO.getPassword()));
        profile.setStatus(GeneralStatus.ACTIVE);
        profile.setRole(Role.ROLE_USER);
        profileRepository.save(profile);

        log.info(profile.toString());
        return mapper.profileEntityToDTO(profile);
    }

    public ProfileDTO authorization(AuthDTO dto) {

        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));


            if (authentication.isAuthenticated()) {
                CustomUserDetails profile = (CustomUserDetails) authentication.getPrincipal();

                ProfileDTO response = new ProfileDTO();
                response.setName(profile.getName());
                response.setUsername(profile.getUsername());
                response.setRole(profile.getRole());
                response.setAccessToken(JwtUtil.encode(profile.getUsername(), profile.getRole().name()));
                response.setRefreshToken(JwtUtil.generateRefreshToken(profile.getUsername(), profile.getRole().name()));

                return response;
            }
            throw new UsernameNotFoundException("Username or password wrong.");
        } catch (BadCredentialsException e) {
            throw new UsernameNotFoundException("Username or password wrong.");
        }


    }

    @Override
    public Boolean update(Profile profile, Long id) {
        Profile exist = getProfileById(id);
        if (exist.equals(null)) {
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
