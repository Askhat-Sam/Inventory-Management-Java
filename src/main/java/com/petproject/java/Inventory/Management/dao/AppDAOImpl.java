package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.User;
import com.petproject.java.Inventory.Management.enntity.UserDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AppDAOImpl implements AppDAO{

    //define field for entity manager
    private EntityManager entityManager;
    //inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUserById(int theId) {
        return entityManager.find(User.class, theId);
    }

    @Override
    @Transactional
    public void deleteUserById(int theId) {
        //Get user
        User tempUser=entityManager.find(User.class, theId);
        //Delete user
        entityManager.remove(tempUser);
    }

    @Override
    public UserDetail findUserDetailById(int theId) {
        return entityManager.find(UserDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteUserDetailById(int theId) {
        UserDetail tempUserDetail = entityManager.find(UserDetail.class, theId);
        entityManager.remove(tempUserDetail);
    }
}
