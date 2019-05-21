package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HotelBookingsApplication {

        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }

        public static void main(String[] args) {
            SpringApplication.run(HotelBookingsApplication.class, args);
        }
}
