package com.example.demo.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Could not find customer " + id);
    }

}
