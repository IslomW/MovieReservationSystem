package com.sharipov.movie_reservation_system.domain.repository;

import com.sharipov.movie_reservation_system.domain.entity.reservation.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Optional<Reservation> getReservationByProfileId(Long id);

}
