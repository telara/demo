package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    void testOpenAccount() {
        Account account = accountService.createAccount(1L, 100.0);
        assertNotNull(account);
        System.out.println("Account opened: " + account);
    }
}
