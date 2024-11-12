package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {
    }

    public Account(Customer customer) {
        this.customer = customer;
    }

    // Method to add a transaction if amount > 0
    public void addTransaction(double amount) {
        if (amount > 0) {
            Transaction transaction = new Transaction(amount);
            transaction.setAccount(this);
            this.transactions.add(transaction);
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customer=" + customer +
                ", transactions=" + transactions +
                '}';
    }
}
