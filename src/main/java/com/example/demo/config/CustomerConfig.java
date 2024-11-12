package com.example.demo.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            CustomerRepository repository
    ) {
        return args -> {
            Customer telara = new Customer(
                    "Telara",
                    "Doe"
            );
            Customer john = new Customer(
                    "John",
                    "Roe"
            );
            Customer jane = new Customer(
                    "Jane",
                    "Roe"
            );

            repository.saveAll(
                    List.of(telara, john, jane)
            );
        };
    }
}
