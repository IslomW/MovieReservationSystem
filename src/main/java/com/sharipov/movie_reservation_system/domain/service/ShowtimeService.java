package com.sharipov.movie_reservation_system.domain.service;

import com.sharipov.movie_reservation_system.domain.entity.showtime.Showtime;
import com.sharipov.movie_reservation_system.domain.web.dto.ShowtimeDTO;

import java.util.List;

public interface ShowtimeService {
    List<Showtime> getAllShowtime();

    Showtime getShowtimeById(Long id);

    Showtime getShowtimeByMovieId(Long id);

    ShowtimeDTO create(ShowtimeDTO showtimeDTO);

    Showtime update(Showtime showtime, Long id);

    void delete(Long id);
}
