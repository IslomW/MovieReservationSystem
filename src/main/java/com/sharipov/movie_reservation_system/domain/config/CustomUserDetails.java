package com.sharipov.movie_reservation_system.domain.config;

import com.sharipov.movie_reservation_system.domain.entity.profile.GeneralStatus;
import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.entity.profile.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Data
@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private Long id;
    private String name;
    private String username;
    private String password;
    private Role role;
    private GeneralStatus status;

    public CustomUserDetails(Profile profile) {
        this.id = profile.getId();
        this.name = profile.getName();
        this.username = profile.getUsername();
        this.password = profile.getPassword();
        this.role = profile.getRole();
        this.status = profile.getStatus();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
