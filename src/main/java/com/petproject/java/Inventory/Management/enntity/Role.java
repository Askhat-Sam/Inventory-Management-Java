package com.petproject.java.Inventory.Management.enntity;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="user_roles")
    private String userRoles;

    public Role() {
    }

    public Role(String userRoles) {
        this.userRoles = userRoles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "Roles{" +
                ", roles='" + userRoles + '\'' +
                '}';
    }
}
