package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.enntity.Tool;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ToolService {

    List<Tool> findAll(String keyword);
    Tool findById(int theId);

    void save(Tool theTool);

    void deleteById(int theId);

    //get tool by keyword
    public List<Tool> findByKeyWord(String keyword);


}
