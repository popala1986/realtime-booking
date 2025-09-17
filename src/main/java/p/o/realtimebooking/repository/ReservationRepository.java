package p.o.realtimebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.o.realtimebooking.model.Reservation;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByExpiresAtBefore(LocalDateTime expirationTime);

    Optional<Reservation> findBySeatIdAndUserEmail(Long seatId, String email);
}