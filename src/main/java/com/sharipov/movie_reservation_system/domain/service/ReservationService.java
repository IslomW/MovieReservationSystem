package com.sharipov.movie_reservation_system.domain.service;

import com.sharipov.movie_reservation_system.domain.entity.reservation.Reservation;
import com.sharipov.movie_reservation_system.domain.web.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {

    List<ReservationDTO> getAllReservations();

    ReservationDTO getReservationById(Long id);

    ReservationDTO create(ReservationDTO reservationDTO);

    ReservationDTO update(ReservationDTO reservationDTO, Long id);
    void deleteReservationById(Long id);
}
