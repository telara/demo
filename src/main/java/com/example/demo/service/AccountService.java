package com.example.demo.service;

import com.example.demo.model.Account;

public interface AccountService {

    // used as createAccount(customerId, initialCredit)
    public Account createAccount(Long customerId, double initialCredit);

}
