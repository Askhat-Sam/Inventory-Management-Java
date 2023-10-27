package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.enntity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    User findByUserId(Integer theId);

    void save(User theUser);

    void update(User theUser);
}
