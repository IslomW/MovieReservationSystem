package com.sharipov.movie_reservation_system.domain.web.controller;


import com.sharipov.movie_reservation_system.domain.entity.reservation.Reservation;
import com.sharipov.movie_reservation_system.domain.service.ReservationService;
import com.sharipov.movie_reservation_system.domain.web.dto.ReservationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservation")
@RequiredArgsConstructor
@Tag(
        name = "Reservation Controller",
        description = "Reservation API"
)
public class ReservationController {

    private final ReservationService reservationService;


    @GetMapping
    @Operation(summary = "Get all reservations.")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<ReservationDTO> reservationList = reservationService.getAllReservations();
        return ResponseEntity.ok(reservationList);
    }


    @GetMapping("{id}")
    @Operation(summary = "Get reservation by id.")
    public ResponseEntity<ReservationDTO> getReservation(@PathVariable("id") Long id) {
        ReservationDTO reservationDTO = reservationService.getReservationById(id);
        return ResponseEntity.ok(reservationDTO);
    }


    @PostMapping
    @Operation(summary = "Create reservation.")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        ReservationDTO response = reservationService.create(reservationDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete reservation.")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") Long id) {
        reservationService.deleteReservationById(id);
        return ResponseEntity.ok().build();
    }
}
