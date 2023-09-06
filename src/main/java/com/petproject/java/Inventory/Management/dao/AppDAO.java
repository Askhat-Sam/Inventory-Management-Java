package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.User;
import com.petproject.java.Inventory.Management.enntity.UserDetail;

public interface AppDAO {
    void save(User user);
    User findUserById(int theId);

    void deleteUserById(int theId);
    UserDetail findUserDetailById(int theInd);

    void deleteUserDetailById(int theId);


}
