package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Account;
import com.example.demo.service.AccountServiceImpl;

/*
Pseudocode:
1. Define an `AccountController` class to handle API requests for account operations.
2. Provide an endpoint to open a new account by accepting customer ID and initial credit as input.
   - If the initial credit is greater than 0, create a transaction for the account.
3. Provide another endpoint to retrieve customer information including name, surname, balance, and transactions.
4. This controller handles incoming HTTP requests and sends responses based on service interactions.
*/

@RestController
@RequestMapping("api")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    /**
     * Endpoint to open a new account with optional initial credit.
     * @param customerId ID of the customer who owns the account.
     * @param initialCredit Initial credit amount for the account.
     * @return The newly created account or an error message if customer is not found or account exists.
     */
    @PostMapping("/account")
    public Account openAccount(@RequestParam Long customerId, @RequestParam double initialCredit) {
        return accountService.createAccount(customerId, initialCredit);
    }
}