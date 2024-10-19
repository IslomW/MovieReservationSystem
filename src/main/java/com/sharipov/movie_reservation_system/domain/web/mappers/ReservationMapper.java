package com.sharipov.movie_reservation_system.domain.web.mappers;

import com.sharipov.movie_reservation_system.domain.entity.reservation.Reservation;
import com.sharipov.movie_reservation_system.domain.web.dto.ReservationDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ReservationMapper {
    public static Reservation reservationDTOToEntity(ReservationDTO dto) {
        Reservation reservation = new Reservation();
        reservation.setSeatNumber(dto.getSeatNumber());
        reservation.setStatus(dto.getStatus());
        reservation.setShowtime(dto.getShowtime());
        reservation.setProfile(dto.getProfile());
        return reservation;

    }

    public static ReservationDTO reservationEntityToDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setSeatNumber(reservation.getSeatNumber());
        dto.setStatus(reservation.getStatus());
        dto.setShowtime(reservation.getShowtime());
        dto.setProfile(reservation.getProfile());
        return dto;
    }

    public List<Reservation> reservationDTOSToList(List<ReservationDTO> reservationDTOS){
        return reservationDTOS.stream()
                .map(ReservationMapper::reservationDTOToEntity)
                .collect(Collectors.toList());
    }

    public List<ReservationDTO> reservationListToDTOS(List<Reservation> reservationList){
        return reservationList.stream()
                .map(ReservationMapper::reservationEntityToDTO)
                .collect(Collectors.toList());
    }
}
