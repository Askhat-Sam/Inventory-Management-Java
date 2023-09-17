package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.User;
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
    public User findUserByUserId(String userId) {
        return entityManager.find(User.class, userId);
    }
//
    @Override
    @Transactional
    public void deleteByUserId(String userId) {
        //Get user
        User tempUser=entityManager.find(User.class, userId);
        //Delete user
        entityManager.remove(tempUser);
    }

//    @Override
//    @Transactional
//    public void deleteUserDetailById(int theId) {
//        UserDetail tempUserDetail = entityManager.find(UserDetail.class, theId);
//        //remove associated object reference
//        //break bi-directional link
//        tempUserDetail.getUser().setUserDetail(null);
//
//        entityManager.remove(tempUserDetail);
//    }
}
