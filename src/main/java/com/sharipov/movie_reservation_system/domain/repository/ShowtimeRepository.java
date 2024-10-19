package com.sharipov.movie_reservation_system.domain.repository;

import com.sharipov.movie_reservation_system.domain.entity.showtime.Showtime;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShowtimeRepository extends CrudRepository<Showtime, Long> {
    Optional<Showtime> getShowtimesByMovie_Id(Long id);

}
