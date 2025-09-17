package p.o.realtimebooking.model;

import lombok.Data;

@Data
public class SeatUpdateMessage {
    private Long seatId;
    private String status;

    public SeatUpdateMessage(Long seatId, String status) {
        this.seatId = seatId;
        this.status = status;
    }
}