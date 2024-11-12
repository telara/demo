package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate ID
    private long id;

    private String name;
    private String surname;

    @OneToOne(mappedBy = "customer")  // Indicates the relationship with Account
    @JsonManagedReference  // Prevents infinite recursion
    private Account account;

    // Default constructor
    public Customer() {
    }

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Customer(String name, String surname, Account account) {
        this.name = name;
        this.surname = surname;
        this.account = account;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    // Calculated balance based on all account transactions
    public double getBalance() {
        return account != null ? account.getTransactions().stream()
                .mapToDouble(Transaction::getAmount)
                .sum() : 0.0;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + getBalance() +
                ", account=" + account +
                '}';
    }
}
