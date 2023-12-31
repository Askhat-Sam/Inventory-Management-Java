package com.petproject.java.Inventory.Management.enntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="user_id")
    private String userId;
    @Column(name="user_role")
    private String userRole;
    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="join_id")
    private User user;

    @Column(insertable=false, updatable=false, name="join_id")
    private long joinId;


    public Role() {
    }

    public Role(String userRole) {
        this.userRole = userRole;
    }

    public Role(String userId,  String userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return this.getUserRole();
    }
}