package com.sharipov.movie_reservation_system.domain.web.controller;


import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import com.sharipov.movie_reservation_system.domain.entity.showtime.Showtime;
import com.sharipov.movie_reservation_system.domain.service.MovieService;
import com.sharipov.movie_reservation_system.domain.service.ShowtimeService;
import com.sharipov.movie_reservation_system.domain.web.dto.ShowtimeDTO;
import com.sharipov.movie_reservation_system.domain.web.mappers.ShowTimeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/showtime")
@RequiredArgsConstructor
@Slf4j
public class ShowtimeController {
    private final ShowTimeMapper mapper;

    private final ShowtimeService showtimeService;


    @GetMapping
    public ResponseEntity<List<Showtime>> getAllShowtime() {
        List<Showtime> showtimes = showtimeService.getAllShowtime();
        return ResponseEntity.ok(showtimes);
    }

    @GetMapping("{id}")
    public ShowtimeDTO getShowtimeById(@PathVariable("id") Long id) {
        Showtime showtime = showtimeService.getShowtimeById(id);
        return ResponseEntity.ok(mapper.showtimeEntityToDTO(showtime)).getBody();
    }

    @PostMapping()
    public ShowtimeDTO createShowtime(@RequestBody ShowtimeDTO showtimeDTO) {

        ShowtimeDTO dto = showtimeService.create(showtimeDTO);
        return ResponseEntity.ok(dto).getBody();
    }


    @DeleteMapping
    public void deleteShowtime(Long id) {
        showtimeService.delete(id);
    }
}
