package com.petproject.java.Inventory.Management.enntity;

import jakarta.persistence.*;

@Entity
@Table(name="user_detail")
public class UserDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="department")
    private String department;
    @OneToOne(mappedBy = "userDetail", cascade = CascadeType.ALL)
    private User user;

    public UserDetail() {
    }


    public UserDetail(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", department='" + department + '\'' +
                '}';
    }
}
