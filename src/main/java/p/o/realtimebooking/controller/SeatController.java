package p.o.realtimebooking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p.o.realtimebooking.model.Reservation;
import p.o.realtimebooking.model.Seat;
import p.o.realtimebooking.service.ReservationService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SeatController {

    private final ReservationService reservationService;

    @GetMapping("/")
    public String index(Model model) {
        List<Seat> seats = reservationService.getAllSeats();
        model.addAttribute("seats", seats);
        return "index";
    }

    @PostMapping("/reserve/{seatId}")
    @ResponseBody
    public ResponseEntity<Reservation> reserveSeat(@PathVariable Long seatId, Principal principal) {
        Reservation reservation = reservationService.reserveSeat(seatId, principal.getName());
        return ResponseEntity.ok(reservation);
    }
}