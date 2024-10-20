package com.sharipov.movie_reservation_system.domain.web.controller;


import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import com.sharipov.movie_reservation_system.domain.entity.showtime.Showtime;
import com.sharipov.movie_reservation_system.domain.service.MovieService;
import com.sharipov.movie_reservation_system.domain.service.ShowtimeService;
import com.sharipov.movie_reservation_system.domain.web.dto.ShowtimeDTO;
import com.sharipov.movie_reservation_system.domain.web.mappers.ShowTimeMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/showtime")
@RequiredArgsConstructor
@Tag(
        name = "Showtime Controller",
        description = "Showtime API"
)
public class ShowtimeController {
    private final ShowTimeMapper mapper;

    private final ShowtimeService showtimeService;


    @GetMapping
    @Operation(summary = "Get all showtime.")
    public ResponseEntity<List<Showtime>> getAllShowtime() {
        List<Showtime> showtimes = showtimeService.getAllShowtime();
        return ResponseEntity.ok(showtimes);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get showtime by id.")
    public ShowtimeDTO getShowtimeById(@PathVariable("id") Long id) {
        Showtime showtime = showtimeService.getShowtimeById(id);
        return ResponseEntity.ok(mapper.showtimeEntityToDTO(showtime)).getBody();
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Create showtime.(Only Admins)")
    public ShowtimeDTO createShowtime(@RequestBody ShowtimeDTO showtimeDTO) {

        ShowtimeDTO dto = showtimeService.create(showtimeDTO);
        return ResponseEntity.ok(dto).getBody();
    }


    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Delete showtime by id.(Only Admins)")
    public void deleteShowtime(Long id) {
        showtimeService.delete(id);
    }
}
