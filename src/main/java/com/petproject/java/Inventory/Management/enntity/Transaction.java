package com.petproject.java.Inventory.Management.enntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Transaction {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="date")
    private String date;
    @Column(name="user")
    private String user;
    @Column(name="tool_id")
    private String toolId;
    @Column(name="transaction_type")
    private String transactionType;

    public Transaction() {
    }

    public Transaction(String date, String user, String toolId, String transactionType) {
        this.date = date;
        this.user = user;
        this.toolId = toolId;
        this.transactionType = transactionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", user='" + user + '\'' +
                ", toolId='" + toolId + '\'' +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
