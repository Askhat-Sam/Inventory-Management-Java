//package com.petproject.java.Inventory.Management.controller;
//
//import com.petproject.java.Inventory.Management.enntity.Transaction;
//import com.petproject.java.Inventory.Management.service.TransactionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//public class TransactionController {
//
//    private TransactionService transactionService;
//    @Autowired
//    public TransactionController(TransactionService transactionService) {
//        this.transactionService = transactionService;
//    }
//
//
////
//    @RequestMapping("/transactions")
//    public String transactionHistory(Model theModel){
//        List<Transaction> theTransactions = transactionService.findAll();
//        System.out.println("Transactions from SQL " + theTransactions);
//        theModel.addAttribute("transactions", theTransactions);
//        return "transaction-history";
//    }
//
//}
