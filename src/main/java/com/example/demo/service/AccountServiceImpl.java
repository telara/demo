package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.AccountAlreadyExistsException;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;

import jakarta.transaction.Transactional;

/*
Pseudocode:
1. Define an `AccountServiceImpl` class to handle business logic for account operations.
2. Use `AccountRepository` to create and save account data.
3. Use `TransactionRepository` to create and save transactions if an initial deposit is provided.
4. Provide methods to create a new account and to fetch transactions for an account.
5. This service coordinates account and transaction management for each account.
*/

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Account createAccount(Long customerId, double initialCredit) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        // Check if customer already has an account
        if (!accountRepository.findByCustomerId(customerId).isEmpty()) {
            throw new AccountAlreadyExistsException(customerId);
        }

        // Create a new account object
        Account newAccount = new Account(customer);
        accountRepository.save(newAccount);

        // Add initial transaction if the credit is greater than zero
        if (initialCredit > 0) {
            newAccount.addTransaction(initialCredit);
            accountRepository.save(newAccount);  // Save again to persist the transaction
        }

        return newAccount;
    }
}