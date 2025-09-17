package p.o.realtimebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RealtimeBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealtimeBookingApplication.class, args);
    }

}
