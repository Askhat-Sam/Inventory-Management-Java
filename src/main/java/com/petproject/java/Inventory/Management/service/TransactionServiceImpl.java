package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.dao.TransactionRepository;
import com.petproject.java.Inventory.Management.enntity.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService {
    TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> findAll(String keyword) {
        if (keyword !=null){
            return transactionRepository.findAll(keyword);
        }
        System.out.println(transactionRepository);
        return transactionRepository.findAll();
    }

    @Override
    public void save(Transaction theTransaction) {
        transactionRepository.save(theTransaction);
    }
}
