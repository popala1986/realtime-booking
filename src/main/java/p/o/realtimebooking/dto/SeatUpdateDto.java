package p.o.realtimebooking.dto;

import lombok.Data;
import p.o.realtimebooking.model.SeatStatus;

@Data
public class SeatUpdateDto {
    private Long id;
    private int rowNum;
    private int seatNum;
    private SeatStatus status;
}