package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.dao.UserRepository;
import com.petproject.java.Inventory.Management.enntity.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
