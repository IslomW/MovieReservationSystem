package com.sharipov.movie_reservation_system.domain.web.mappers;

import com.sharipov.movie_reservation_system.domain.entity.showtime.Showtime;
import com.sharipov.movie_reservation_system.domain.web.dto.ShowtimeDTO;
import org.springframework.stereotype.Component;


@Component
public class ShowTimeMapper {
    public Showtime showtimeDTOToEntity(ShowtimeDTO dto) {
        Showtime showtime = new Showtime();
        showtime.setDate(dto.getDate());
        showtime.setTime(dto.getTime());
        showtime.setCinema_hall(dto.getCinema_hall());
        showtime.setCapacity(dto.getCapacity());
        showtime.setMovieId(dto.getMovie_id());
        return showtime;
    }

    public ShowtimeDTO showtimeEntityToDTO(Showtime showtime) {
        ShowtimeDTO dto = new ShowtimeDTO();
        dto.setDate(showtime.getDate());
        dto.setTime(showtime.getTime());
        dto.setCinema_hall(showtime.getCinema_hall());
        dto.setCapacity(showtime.getCapacity());
        dto.setMovie(showtime.getMovie());
        return dto;
    }
}
