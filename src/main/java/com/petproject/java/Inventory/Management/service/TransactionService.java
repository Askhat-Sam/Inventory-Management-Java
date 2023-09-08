package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.enntity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionService {
    List<Transaction> findAll();
}
//