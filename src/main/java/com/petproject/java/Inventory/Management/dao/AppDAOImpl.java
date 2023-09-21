package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.Role;
import com.petproject.java.Inventory.Management.enntity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        // get the roles
        List<Role> roles = tempUser.getRoles();
        //break association of all roles for the user
        for (Role role: roles){
            role.setUser(null);
        }
        //Delete user
        entityManager.remove(tempUser);
    }

    @Override
    public List<Role> findRolesByUserId(String userId) {
        //create query
        TypedQuery<Role> query = entityManager.createQuery(
                "SELECT r FROM Role r WHERE r.user.userId = :data", Role.class);

        query.setParameter("data", userId);

        List<Role> roles = query.getResultList();

        return roles;
    }

    @Override
    public User findUserByUserIdJoinFetch(String userId) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT i from User i JOIN FETCH" +
                        " i.roles WHERE i.userId = : data", User.class);
        query.setParameter("data", userId);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(User tempUser) {
        entityManager.merge(tempUser);
    }

    @Override
    @Transactional
    public void update(Role tempRole) {
        entityManager.merge(tempRole);
    }

    @Override
    public Role findRoleByUserId(int id) {
        return entityManager.find(Role.class, id);

    }

//    public User findUserByUserId(String userId) {
//        return entityManager.find(User.class, userId);
//    }

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
