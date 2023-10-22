package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.dao.UserRepository;
import com.petproject.java.Inventory.Management.enntity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        System.out.println(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
