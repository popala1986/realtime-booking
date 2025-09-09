package p.o.realtimebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.o.realtimebooking.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
