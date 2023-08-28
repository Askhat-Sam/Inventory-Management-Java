package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.dao.ToolRepository;
import com.petproject.java.Inventory.Management.enntity.Tool;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ToolServiceImpl implements ToolService{

    private ToolRepository toolRepository;

    public ToolServiceImpl(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @Override
    public List<Tool> findAll() {
        return toolRepository.findAll();
    }

    @Override
    public Tool findById(int theId) {
        Optional<Tool> result = toolRepository.findById(theId);

        Tool theTool = null;

        if (result.isPresent()){
            theTool = result.get();
        } else {
            throw new RuntimeException("Did not find tool id "+ theId);
        }
        return theTool;
    }

    @Override
    public void save(Tool theTool) {
        toolRepository.save(theTool);
    }

    @Override
    public void deleteById(int theId) {
        toolRepository.deleteById(theId);
    }
}
