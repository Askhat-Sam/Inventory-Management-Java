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

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void update(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void deleteUserById(User theUser) {
        userRepository.delete(theUser);
    }

    @Override
    public User findByUserId(Integer theId) {
        return userRepository.findByUserId(theId);
    }

    @Override
    public long getUserCount() {
        return userRepository.count();
    }

}
