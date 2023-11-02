package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    public List<User> findAll();

    @Query("SELECT u FROM User u WHERE u.id= :theId")
    public User findByUserId(@Param("theId") Integer theId);

    long count();
}
