package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;

// Use Spring Data JPA will generate the necessary database interactions for these repositories.

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByCustomerId(Long customerId);
}
