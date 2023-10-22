package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.enntity.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public List<User> findAll() {
        return UserRepository.findAll;
    }
}
