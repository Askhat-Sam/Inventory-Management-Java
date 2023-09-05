package com.petproject.java.Inventory.Management.enntity;

import jakarta.persistence.*;

@Entity
@Table(name="user_detail")
public class UserDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="department")
    private String department;

}
