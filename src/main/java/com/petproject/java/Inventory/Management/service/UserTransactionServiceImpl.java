package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.dao.UserTransactionRepository;
import com.petproject.java.Inventory.Management.enntity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserTransactionServiceImpl implements UserTransactionService{
    @Autowired
    UserTransactionRepository userTransactionRepository;


    @Override
    public List<Transaction> findAll(String keyword) {
        if (keyword !=null){
            return userTransactionRepository.findAll(keyword);
        }
        System.out.println(userTransactionRepository);
        return userTransactionRepository.findAll();
    }

    @Override
    public void save(Transaction theTransaction) {
        userTransactionRepository.save(theTransaction);
    }
}
