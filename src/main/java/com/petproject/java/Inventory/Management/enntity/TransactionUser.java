package com.petproject.java.Inventory.Management.enntity;

import jakarta.persistence.*;

@Entity
@Table(name="transaction_user")
public class TransactionUser {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int transactionId;
    @Column(name="date")
    private String date;
    @Column(name="user")
    private String user;
    @Column(name="user_id")
    private int toolId;
    @Column(name="transaction_type")
    private String transactionType;

    public TransactionUser() {
    }

    public TransactionUser(String date, String user, int toolId, String transactionType) {
        this.date = date;
        this.user = user;
        this.toolId = toolId;
        this.transactionType = transactionType;
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

    public int getToolId() {
        return toolId;
    }

    public void setToolId(int toolId) {
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
        return "TransactionUser{" +
                "transactionId=" + transactionId +
                ", date='" + date + '\'' +
                ", user='" + user + '\'' +
                ", toolId=" + toolId +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
