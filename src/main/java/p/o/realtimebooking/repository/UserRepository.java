package p.o.realtimebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import p.o.realtimebooking.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);


}
