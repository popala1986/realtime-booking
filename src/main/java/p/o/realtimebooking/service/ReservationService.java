package p.o.realtimebooking.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import p.o.realtimebooking.model.Seat;
import p.o.realtimebooking.model.SeatStatus;
import p.o.realtimebooking.repository.SeatRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final SeatRepository seatRepository;

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Transactional
    public Seat reserveSeat(Long seatId) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found!"));

        if (seat.getStatus() != SeatStatus.AVAILABLE) {
            throw new RuntimeException("Seat is already booked!");
        }

        seat.setStatus(SeatStatus.RESERVED);
        return seatRepository.save(seat);
    }

    @Transactional
    public Seat releaseSeat(Long seatId) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found!"));

        if (seat.getStatus() == SeatStatus.AVAILABLE) {
            throw new RuntimeException("Seat is already available!");
        }

        seat.setStatus(SeatStatus.AVAILABLE);
        return seatRepository.save(seat);
    }

    @Transactional
    public Seat occupySeat(Long seatId) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found!"));

        if (seat.getStatus() != SeatStatus.RESERVED) {
            throw new RuntimeException("Seat must be reserved before occupying!");
        }

        seat.setStatus(SeatStatus.OCCUPIED);
        return seatRepository.save(seat);
    }
}
