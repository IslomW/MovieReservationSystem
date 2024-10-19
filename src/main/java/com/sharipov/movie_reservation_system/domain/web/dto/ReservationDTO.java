package com.sharipov.movie_reservation_system.domain.web.dto;

import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.entity.reservation.Status;
import com.sharipov.movie_reservation_system.domain.entity.showtime.Showtime;
import lombok.Data;


@Data
public class ReservationDTO {
    private String seatNumber;

    private Status status;

    private Long profileId;
    private Long showtimeId;

    private Showtime showtime;

    private Profile profile;

}
