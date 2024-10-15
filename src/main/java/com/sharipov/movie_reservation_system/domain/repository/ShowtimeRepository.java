package com.sharipov.movie_reservation_system.domain.repository;

import com.sharipov.movie_reservation_system.domain.entity.showtime.Showtime;
import org.springframework.data.repository.CrudRepository;

public interface ShowtimeRepository extends CrudRepository<Showtime, Long> {

}
