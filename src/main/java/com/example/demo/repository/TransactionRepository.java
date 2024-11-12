package com.example.demo.repository;

import com.example.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Because an account can have multiple transactions, the findByAccountId method returns a List<Transaction>, allowing you to handle multiple results.
    List<Transaction> findByAccountId(long accountId);
}
