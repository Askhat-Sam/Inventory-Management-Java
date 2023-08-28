package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.enntity.Tool;

import java.util.List;

public interface ToolService {

    List<Tool> findAll();
    Tool findById(int theId);

    void save(Tool theTool);

    void deleteById(int theId);
}
