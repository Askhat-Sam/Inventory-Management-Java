package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.Role;
import com.petproject.java.Inventory.Management.enntity.User;

import java.util.List;

public interface AppDAO {
    void save(User user);
    User findUserByUserId(String userId);

    void deleteByUserId(String userId);

    List<Role> findRolesByUserId(String userId);

    User findUserByUserIdJoinFetch(String userId);

//    void deleteUserDetailById(int theId); TOOOOOOOOOOOOOOOOOOOO BE FIXED


}
