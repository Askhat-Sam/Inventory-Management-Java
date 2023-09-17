package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.User;

public interface AppDAO {
    void save(User user);
    User findUserByUserId(String userId);

    void deleteByUserId(String userId);

//    void deleteUserDetailById(int theId); TOOOOOOOOOOOOOOOOOOOO BE FIXED


}
