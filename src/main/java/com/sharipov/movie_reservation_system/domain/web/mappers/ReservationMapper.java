package com.sharipov.movie_reservation_system.domain.web.mappers;

import com.sharipov.movie_reservation_system.domain.entity.reservation.Reservation;
import com.sharipov.movie_reservation_system.domain.web.dto.ReservationDTO;

public class ReservationMapper {
    public Reservation reservationDTOToEntity(ReservationDTO dto) {
        Reservation reservation = new Reservation();
        reservation.setSeatNumber(dto.getSeatNumber());
        reservation.setStatus(dto.getStatus());
        reservation.setShowtime(dto.getShowtime());
        reservation.setProfile(dto.getProfile());
        return reservation;

    }

    public ReservationDTO reservationEntityToDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setSeatNumber(reservation.getSeatNumber());
        dto.setStatus(reservation.getStatus());
        dto.setShowtime(reservation.getShowtime());
        dto.setProfile(reservation.getProfile());
        return dto;
    }
}
