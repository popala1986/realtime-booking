package p.o.realtimebooking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Seat seat;

    private LocalDateTime reservationTime;

    private LocalDateTime expiresAt;
}