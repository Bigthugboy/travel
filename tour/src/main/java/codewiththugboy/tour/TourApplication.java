package codewiththugboy.tour;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "tourist")
public class TourApplication {

    public static void main(String[] args) {
        SpringApplication.run(TourApplication.class, args);
    }

}
