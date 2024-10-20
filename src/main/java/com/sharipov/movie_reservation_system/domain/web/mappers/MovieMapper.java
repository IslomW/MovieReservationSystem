package com.sharipov.movie_reservation_system.domain.web.mappers;

import com.sharipov.movie_reservation_system.domain.entity.movie.Movie;
import com.sharipov.movie_reservation_system.domain.entity.reservation.Reservation;
import com.sharipov.movie_reservation_system.domain.web.dto.MovieDTO;
import com.sharipov.movie_reservation_system.domain.web.dto.ReservationDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class MovieMapper {

    public static Movie movieDTOToEntity(MovieDTO dto) {
        Movie movie = new Movie();
        movie.setTitle(dto.getTitle());
        movie.setDescription(dto.getDescription());
        movie.setGenres(dto.getGenres());
        return movie;
    }

    public static MovieDTO movieEntityToDTO(Movie movie) {
        MovieDTO dto = new MovieDTO();
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        dto.setGenres(movie.getGenres());
        return dto;
    }

    public List<Movie> movieDTOSToList(List<MovieDTO> movieDTOS){
        return movieDTOS.stream()
                .map(MovieMapper::movieDTOToEntity)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> movieListToDTOS(List<Movie> movies){
        return movies.stream()
                .map(MovieMapper::movieEntityToDTO)
                .collect(Collectors.toList());
    }

}
