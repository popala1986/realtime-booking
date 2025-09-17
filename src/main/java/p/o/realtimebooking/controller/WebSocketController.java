
package p.o.realtimebooking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import p.o.realtimebooking.dto.SeatUpdateDto;
import p.o.realtimebooking.model.Reservation;
import p.o.realtimebooking.model.Seat;
import p.o.realtimebooking.service.ReservationService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebSocketController {

    private final ReservationService reservationService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/reserve/{seatId}")
    public void reserveSeat(@DestinationVariable Long seatId, Principal principal) {
        if (principal == null) {
            return;
        }
        try {
            String email = principal.getName();
            Reservation reservation = reservationService.reserveSeat(seatId, email);
            Seat updatedSeat = reservation.getSeat();

            // Użycie DTO do wysłania wiadomości
            SeatUpdateDto dto = new SeatUpdateDto();
            dto.setId(updatedSeat.getId());
            dto.setRowNum(updatedSeat.getRowNum());
            dto.setSeatNum(updatedSeat.getSeatNum());
            dto.setStatus(updatedSeat.getStatus());

            messagingTemplate.convertAndSend("/topic/seats/update", dto);
        } catch (Exception e) {
            System.err.println("Błąd rezerwacji: " + e.getMessage());
        }
    }

    @MessageMapping("/cancel/{seatId}")
    public void cancelReservation(@DestinationVariable Long seatId, Principal principal) {
        if (principal == null) {
            return;
        }
        try {
            String email = principal.getName();
            Reservation canceledReservation = reservationService.cancelReservation(seatId, email);
            if (canceledReservation != null) {
                Seat updatedSeat = canceledReservation.getSeat();

                SeatUpdateDto dto = new SeatUpdateDto();
                dto.setId(updatedSeat.getId());
                dto.setRowNum(updatedSeat.getRowNum());
                dto.setSeatNum(updatedSeat.getSeatNum());
                dto.setStatus(updatedSeat.getStatus());

                messagingTemplate.convertAndSend("/topic/seats/update", dto);
            }
        } catch (Exception e) {
            System.err.println("Błąd anulowania rezerwacji: " + e.getMessage());
        }
    }

    @Scheduled(fixedRate = 60000)
    public void notifyAboutFreedSeats() {
        List<Seat> freedSeats = reservationService.removeExpiredReservations();

        for (Seat seat : freedSeats) {
            SeatUpdateDto dto = new SeatUpdateDto();
            dto.setId(seat.getId());
            dto.setRowNum(seat.getRowNum());
            dto.setSeatNum(seat.getSeatNum());
            dto.setStatus(seat.getStatus());

            messagingTemplate.convertAndSend("/topic/seats/update", dto);
        }
    }
}