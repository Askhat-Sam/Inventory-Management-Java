package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.enntity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
//    @Query(value = "SELECT * from transaction t", nativeQuery = true)
//    public List<Transaction> findAll();

    @Query(value = "SELECT * from transaction s WHERE " +
            "s.id like %:keyword% OR s.user like %:keyword% " +
            "OR s.tool_id LIKE %:keyword% OR s.transaction_type like %:keyword%", nativeQuery = true)
    public List<Transaction> findAll(@Param("keyword") String keyword);
}