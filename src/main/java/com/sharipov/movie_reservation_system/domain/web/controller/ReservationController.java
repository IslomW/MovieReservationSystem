package com.sharipov.movie_reservation_system.domain.web.controller;


import com.sharipov.movie_reservation_system.domain.entity.reservation.Reservation;
import com.sharipov.movie_reservation_system.domain.service.ReservationService;
import com.sharipov.movie_reservation_system.domain.web.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservation")
@RequiredArgsConstructor
@Slf4j
public class ReservationController {

    private final ReservationService reservationService;


    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<ReservationDTO> reservationList = reservationService.getAllReservations();
        return ResponseEntity.ok(reservationList);
    }


    @GetMapping("{id}")
    public ResponseEntity<ReservationDTO> getReservation(@PathVariable("id") Long id) {
        ReservationDTO reservationDTO = reservationService.getReservationById(id);
        return ResponseEntity.ok(reservationDTO);
    }


    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        ReservationDTO response = reservationService.create(reservationDTO);
        return ResponseEntity.ok(response);
    }

}
