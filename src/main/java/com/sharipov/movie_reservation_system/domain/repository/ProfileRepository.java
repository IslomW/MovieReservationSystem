package com.sharipov.movie_reservation_system.domain.repository;

import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
