package com.petproject.java.Inventory.Management.enntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
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

    public TransactionUser(String date, String user, int toolId, String transactionType) {
        this.date = date;
        this.user = user;
        this.toolId = toolId;
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
