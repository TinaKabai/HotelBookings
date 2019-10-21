package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})

@SpringBootApplication
public class HotelBookingsApplication {

        /*@Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }*/

        public static void main(String[] args) {
            SpringApplication.run(HotelBookingsApplication.class, args);
        }
}
