package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "SELECT * from transaction t", nativeQuery = true)
    public List<Transaction> findAll();
}
//