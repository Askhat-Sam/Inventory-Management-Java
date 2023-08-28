package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.Tool;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ToolDaoImpl implements ToolDao{
    private EntityManager entityManager;
    @Autowired
    public ToolDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Tool> findAll() {
        TypedQuery<Tool> theQuery = entityManager.createQuery("from Tool",Tool.class);

        List<Tool> tools = theQuery.getResultList();

        return tools;
    }
}
