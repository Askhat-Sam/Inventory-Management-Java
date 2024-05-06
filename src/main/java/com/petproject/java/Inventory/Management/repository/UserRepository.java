package com.petproject.java.Inventory.Management.repository;

import com.petproject.java.Inventory.Management.enntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findAll();

    long count();
}
