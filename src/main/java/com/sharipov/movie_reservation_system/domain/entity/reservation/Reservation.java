package com.sharipov.movie_reservation_system.domain.entity.reservation;

import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.entity.showtime.Showtime;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seatNumber;
    private LocalDateTime createdAt;

    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "showtime_id", updatable = false, insertable = false)
    private Showtime showtime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", updatable = false, insertable = false)
    private Profile profile;

}
