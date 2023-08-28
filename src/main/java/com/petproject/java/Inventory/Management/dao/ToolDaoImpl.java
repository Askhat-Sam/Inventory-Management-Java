package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.service.ToolService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ToolDaoImpl implements ToolDao{
    private EntityManager entityManager;
    @Autowired
    public ToolDaoImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Tool> findAll() {
        TypedQuery<Tool> theQuery = entityManager.createQuery("from Tool", Tool.class);

        List<Tool> tools = theQuery.getResultList();

        return tools;
    }

    @Override
    public Tool findById(int theId) {
        Tool theTool = entityManager.find(Tool.class, theId);

        return theTool;
    }

    @Override
    public Tool save(Tool theTool) {
        Tool dbTool = entityManager.merge(theTool);
        return dbTool;
    }

    @Override
    public void deleteById(int theId) {
        Tool theTool = entityManager.find(Tool.class, theId);
        entityManager.remove(theTool);
    }
}
