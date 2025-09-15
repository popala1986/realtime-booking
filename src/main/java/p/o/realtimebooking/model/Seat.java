package p.o.realtimebooking.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "row_num")  // <-- tutaj mapujemy pole rowNum na kolumnę row_num w DB
    private int rowNum;

    @Column(name = "seat_num") // <-- mapujemy pole seatNum na kolumnę seat_num w DB
    private int seatNum;

    @Enumerated(EnumType.STRING)
    private SeatStatus status = SeatStatus.AVAILABLE;
}