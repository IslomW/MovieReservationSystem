package com.sharipov.movie_reservation_system.domain.service.impl;

import com.sharipov.movie_reservation_system.domain.entity.showtime.Showtime;
import com.sharipov.movie_reservation_system.domain.exception.ResourceNotFoundException;
import com.sharipov.movie_reservation_system.domain.repository.ShowtimeRepository;
import com.sharipov.movie_reservation_system.domain.service.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {
    private ShowtimeRepository showtimeRepository;

    @Override
    public List<Showtime> getAllShowtime() {
        List<Showtime> showtimes = (List<Showtime>) showtimeRepository.findAll();
        return showtimes;
    }

    @Override
    public Showtime getShowtimeById(Long id) {
        Showtime showtime = showtimeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Showtime not found."));
        return showtime;
    }

    @Override
    public Showtime create(Showtime showtime) {
        showtimeRepository.save(showtime);
        return showtime;
    }

    @Override
    public Showtime update(Showtime showtime, Long id) {
        Showtime exist = getShowtimeById(id);
        return null;
    }

    @Override
    public void delete(Long id) {
        showtimeRepository.deleteById(id);
    }
}
