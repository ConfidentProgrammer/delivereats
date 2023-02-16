package fooddelivery.delivereats.restaurant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class RestaurantConfig {
    @Bean
    CommandLineRunner commandLineRunner(RestaurantRepository repo) {
        return args -> {
            Restaurant q1 = new Restaurant(
                    "Indian Sweet Master", "10 santa anita court", 1.23455
                    , 1.23434, List.of(
                            new Menu("Pani puri", 45.55),
                            new Menu("Ice cream", 6.99)
                    ,new Menu("Dhosha", 4.55),
                    new Menu("Vadapav", 6.99)
            )
            );

            Restaurant q2 = new Restaurant(
                    "Indian magadhi", "1a anita court", 1.23455
                    , 1.23434, List.of(
                    new Menu("Pani puri", 4.55),
                    new Menu("Ice cream", 6.9)
            )
            );




            // repo.saveAll(List.of(q1, q2));
        };
    }
}
