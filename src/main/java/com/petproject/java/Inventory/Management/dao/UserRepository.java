package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findAll();
}
