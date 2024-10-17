package com.sharipov.movie_reservation_system.domain.service.impl;


import com.sharipov.movie_reservation_system.domain.entity.reservation.Reservation;
import com.sharipov.movie_reservation_system.domain.entity.reservation.Status;
import com.sharipov.movie_reservation_system.domain.exception.ResourceNotFoundException;
import com.sharipov.movie_reservation_system.domain.repository.ReservationRepository;
import com.sharipov.movie_reservation_system.domain.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;


    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservationList = (List<Reservation>) reservationRepository.findAll();
        return reservationList;
    }

    @Override
    public Reservation getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Reservation not found."));
        return reservation;
    }

    @Override
    public Reservation create(Reservation reservation) {

        reservation.setCreatedAt(LocalDateTime.now());
        reservation.setStatus(Status.RESERVED);

        reservationRepository.save(reservation);
        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation, Long id) {
        Reservation exist = getReservationById(id);
        /// USerId

        return null;
    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }
}
