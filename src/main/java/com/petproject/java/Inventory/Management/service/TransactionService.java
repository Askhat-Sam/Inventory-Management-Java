package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.enntity.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findAll(String keyword);
    void save(Transaction theTransaction);
}
//