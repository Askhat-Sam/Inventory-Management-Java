package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.repository.ToolTransactionRepository;
import com.petproject.java.Inventory.Management.enntity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToolTransactionServiceImpl implements ToolTransactionService {
    @Autowired
    ToolTransactionRepository toolTransactionRepository;


    @Override
    public List<Transaction> findAll(String keyword) {
        if (keyword !=null){
            return toolTransactionRepository.findAll(keyword);
        }
        System.out.println(toolTransactionRepository);
        return toolTransactionRepository.findAll();
    }

    @Override
    public void save(Transaction theTransaction) {
        toolTransactionRepository.save(theTransaction);
    }
}
