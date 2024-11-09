package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            CustomerRepository repository
    ) {
        return args -> {
            Customer telara = new Customer(
                    "Telara",
                    "JuneBug"
            );
            Customer john = new Customer(
                    "John",
                    "Doe"
            );

            repository.saveAll(
                    List.of(telara, john)
            );
        };
    }
}
