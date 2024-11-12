package com.example.demo.exception;

public class AccountAlreadyExistsException extends RuntimeException {

    public AccountAlreadyExistsException(Long id) {

        super("Account already exists for customer " + id);
    }

}
