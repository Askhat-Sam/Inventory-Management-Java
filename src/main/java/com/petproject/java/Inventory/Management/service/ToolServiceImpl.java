package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.dao.ToolDao;
import com.petproject.java.Inventory.Management.enntity.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToolServiceImpl implements ToolService{

    private ToolDao toolDao;
    @Autowired
    public ToolServiceImpl(ToolDao toolDao) {
        this.toolDao = toolDao;
    }

    @Override
    public List<Tool> findAll() {
        return toolDao.findAll();
    }
}
