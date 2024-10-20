package com.sharipov.movie_reservation_system.domain.entity.reservation;

import com.sharipov.movie_reservation_system.domain.entity.profile.Profile;
import com.sharipov.movie_reservation_system.domain.entity.showtime.Showtime;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Entity
@Schema(hidden = true)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seatNumber;
    private LocalDateTime createdAt;
    private Status status;

    @Column(name = "showtime_id")
    private Long showtimeId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "showtime_id", updatable = false, insertable = false)
    private Showtime showtime;

    @Column(name = "profile_id")
    private Long profileId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id", updatable = false, insertable = false)
    private Profile profile;

}
