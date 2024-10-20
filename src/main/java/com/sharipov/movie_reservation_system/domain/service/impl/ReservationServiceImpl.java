package com.sharipov.movie_reservation_system.domain.service.impl;


import com.sharipov.movie_reservation_system.domain.entity.reservation.Reservation;
import com.sharipov.movie_reservation_system.domain.entity.reservation.Status;
import com.sharipov.movie_reservation_system.domain.exception.ResourceNotFoundException;
import com.sharipov.movie_reservation_system.domain.repository.ReservationRepository;
import com.sharipov.movie_reservation_system.domain.service.ReservationService;
import com.sharipov.movie_reservation_system.domain.web.dto.ReservationDTO;
import com.sharipov.movie_reservation_system.domain.web.mappers.ReservationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper mapper;


    @Override
    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservationList = (List<Reservation>) reservationRepository.findAll();

        return mapper.reservationListToDTOS(reservationList);
    }

    @Override
    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found."));
        return mapper.reservationEntityToDTO(reservation);
    }

    @Override
    public ReservationDTO create(ReservationDTO reservationDTO) {
        Reservation reservation = mapper.reservationDTOToEntity(reservationDTO);

        reservation.setCreatedAt(LocalDateTime.now());
        reservation.setProfileId(reservationDTO.getProfileId());
        reservation.setShowtimeId(reservationDTO.getShowtimeId());
        reservation.setStatus(Status.RESERVED);
        reservationRepository.save(reservation);
        log.info(reservation.toString());

        ReservationDTO response = mapper.reservationEntityToDTO(reservation);
        log.info(response.toString());
        return response;
    }

    @Override
    public ReservationDTO update(ReservationDTO reservationDTO, Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));
        reservation.setShowtime(reservationDTO.getShowtime());
        reservation.setSeatNumber(reservationDTO.getSeatNumber());
        reservationRepository.save(reservation);
        return ReservationMapper.reservationEntityToDTO(reservation);
    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }
}
