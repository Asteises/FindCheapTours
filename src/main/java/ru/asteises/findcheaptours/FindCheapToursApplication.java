package ru.asteises.findcheaptours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FindCheapToursApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindCheapToursApplication.class, args);
    }
}
