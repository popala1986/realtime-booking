
package p.o.realtimebooking.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import p.o.realtimebooking.model.*;
import p.o.realtimebooking.repository.ReservationRepository;
import p.o.realtimebooking.repository.SeatRepository;
import p.o.realtimebooking.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final SeatRepository seatRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Transactional
    public Reservation reserveSeat(Long seatId, String email) {
        Seat seat = seatRepository.findByIdForUpdate(seatId);
        if (seat == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Miejsce nie znalezione");
        }

        if (seat.getStatus() != SeatStatus.AVAILABLE) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Miejsce już zarezerwowane");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Użytkownik nie znaleziony"));

        seat.setStatus(SeatStatus.RESERVED);
        seatRepository.save(seat);

        Reservation reservation = new Reservation();
        reservation.setSeat(seat);
        reservation.setUser(user);
        reservation.setReservationTime(LocalDateTime.now());
        reservation.setExpiresAt(LocalDateTime.now().plusMinutes(1));

        return reservationRepository.save(reservation);
    }

    @Transactional
    public List<Seat> removeExpiredReservations() {
        LocalDateTime now = LocalDateTime.now();
        List<Reservation> expiredReservations = reservationRepository.findAllByExpiresAtBefore(now);
        List<Seat> freedSeats = new ArrayList<>();

        for (Reservation reservation : expiredReservations) {
            Seat seat = reservation.getSeat();
            seat.setStatus(SeatStatus.AVAILABLE);
            seatRepository.save(seat);
            reservationRepository.delete(reservation);
            freedSeats.add(seat);
        }
        System.out.println("Sprawdzono i usunięto wygasłe rezerwacje o: " + now);
        return freedSeats;
    }

    @Transactional
    public Reservation cancelReservation(Long seatId, String email) {
        Reservation reservation = reservationRepository.findBySeatIdAndUserEmail(seatId, email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brak rezerwacji do anulowania."));

        Seat seat = reservation.getSeat();
        seat.setStatus(SeatStatus.AVAILABLE);
        seatRepository.save(seat);

        reservationRepository.delete(reservation);

        return reservation;
    }
}