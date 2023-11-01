package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.enntity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    void save(User theUser);

    void update(User theUser);

    void deleteUserById(User theUser);

    User findByUserId(Integer theId);

}
