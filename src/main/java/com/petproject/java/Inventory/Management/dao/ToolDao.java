package com.petproject.java.Inventory.Management.dao;

import com.petproject.java.Inventory.Management.enntity.Tool;

import java.util.List;

public interface ToolDao {
    List<Tool> findAll();
}
