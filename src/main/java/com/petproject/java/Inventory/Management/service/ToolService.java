package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.enntity.Tool;

import java.util.List;

public interface ToolService {

    List<Tool> findAll(String keyword);
    Tool findById(int theId);

    Tool save(Tool theTool);

    void deleteById(int theId);

    //get tool by keyword
    public List<Tool> findByKeyWord(String keyword);

    public Tool update(Tool theTool);

    public Tool getOne(int theId);
}
