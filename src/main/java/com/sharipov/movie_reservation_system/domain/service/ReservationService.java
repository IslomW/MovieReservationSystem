package com.sharipov.movie_reservation_system.domain.service;

import com.sharipov.movie_reservation_system.domain.entity.reservation.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservations();

    Reservation getReservationById(Long id);

    Reservation create(Reservation reservation);

    Reservation update(Reservation reservation, Long id);
    void deleteReservationById(Long id);
}
