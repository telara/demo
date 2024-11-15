package com.example.demo.controller;

import java.util.List;

import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customers")
    public List<Customer> getCustomers() {

        return customerService.getCustomers();

    }

    /**
     * Endpoint to retrieve customer information including name, surname, balance, and transactions.
     * @param customerId ID of the customer to retrieve.
     * @return Customer information with associated account and transactions.
     */
    @GetMapping("customers/{customerId}")
    public Customer getCustomerInfo(@PathVariable Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
