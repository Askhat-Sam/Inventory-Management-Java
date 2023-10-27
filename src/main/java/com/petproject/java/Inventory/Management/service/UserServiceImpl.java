package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.dao.UserRepository;
import com.petproject.java.Inventory.Management.enntity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User findByUserId(Integer theId) {

        return userRepository.findByUserId(theId);
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }
}
