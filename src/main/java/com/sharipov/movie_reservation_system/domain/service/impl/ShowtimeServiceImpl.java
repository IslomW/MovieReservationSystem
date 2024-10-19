package com.sharipov.movie_reservation_system.domain.service.impl;

import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import com.sharipov.movie_reservation_system.domain.entity.showtime.Showtime;
import com.sharipov.movie_reservation_system.domain.exception.ResourceNotFoundException;
import com.sharipov.movie_reservation_system.domain.repository.MovieRepository;
import com.sharipov.movie_reservation_system.domain.repository.ShowtimeRepository;
import com.sharipov.movie_reservation_system.domain.service.ShowtimeService;
import com.sharipov.movie_reservation_system.domain.web.dto.ShowtimeDTO;
import com.sharipov.movie_reservation_system.domain.web.mappers.ShowTimeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {
    private final ShowtimeRepository showtimeRepository;
    private final MovieRepository movieRepository;
    private final ShowTimeMapper mapper;

    @Override
    public List<Showtime> getAllShowtime() {
        List<Showtime> showtimes = (List<Showtime>) showtimeRepository.findAll();
        if (showtimes.isEmpty()){
            throw new ResourceNotFoundException("Showtime not found");
        }
        return showtimes;
    }

    @Override
    public Showtime getShowtimeById(Long id) {
        Showtime showtime = showtimeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Showtime not found."));
        return showtime;
    }

    @Override
    public Showtime getShowtimeByMovieId(Long id) {
        Showtime showtime = showtimeRepository.getShowtimesByMovie_Id(id)
                .orElseThrow(()-> new ResourceNotFoundException("Showtime not found"));
        return showtime;
    }


    @Override
    public ShowtimeDTO create(ShowtimeDTO showtimeDTO) {
        Showtime showtime = mapper.showtimeDTOToEntity(showtimeDTO);
        showtime.setCreatedAt(LocalDateTime.now());
        showtimeRepository.save(showtime);
        ShowtimeDTO response = mapper.showtimeEntityToDTO(showtime);
        return response;
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
