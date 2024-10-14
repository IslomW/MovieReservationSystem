package com.sharipov.movie_reservation_system.domain.entity.reservation;

import com.sharipov.movie_reservation_system.domain.entity.showtime.Showtime;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


import java.time.LocalDateTime;

public class Reservation {

    private Long id;
    private String seatNumber;
    private LocalDateTime createdAt;

    private Status status;

    @Column(name = "showtime_id")
    private String showtimeId;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "showtime_id", updatable = false, insertable = false)
    private Showtime showtime;

}
