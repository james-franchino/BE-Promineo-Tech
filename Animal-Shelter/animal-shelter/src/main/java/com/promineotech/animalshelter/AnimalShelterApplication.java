package com.promineotech.animalshelter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Animal Shelter application.
 * This class serves as the entry point for the Spring Boot application.
 */

@SpringBootApplication
public class AnimalShelterApplication {

    /**
     * The main method which starts the Spring Boot application.
     *
     * @param args Command line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(AnimalShelterApplication.class, args);
    }

}
