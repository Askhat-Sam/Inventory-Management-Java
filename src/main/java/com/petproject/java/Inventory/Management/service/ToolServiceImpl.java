package com.petproject.java.Inventory.Management.service;

import com.petproject.java.Inventory.Management.repository.ToolRepository;
import com.petproject.java.Inventory.Management.enntity.Tool;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolServiceImpl implements ToolService {

    private ToolRepository toolRepository;

    public ToolServiceImpl(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @Override
    public List<Tool> findAll(String keyword) {
        if (keyword != null) {
            return toolRepository.findAll(keyword);
        }
        return toolRepository.findAll();
    }


    @Override
    public Tool findById(int theId) {
        Optional<Tool> result = toolRepository.findByBarcodeId(theId);

        Tool theTool = null;

        if (result.isPresent()) {
            theTool = result.get();
        } else {
            throw new RuntimeException("Did not find tool id ^_^" + theId);
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

    @Override
    public List<Tool> findByKeyWord(String keyword) {
        return null;
    }

    @Override
    public void update(Tool theTool) {
        toolRepository.save(theTool);
    }

    @Override
    public Tool getOne(int theId) {
        Optional<Tool> result = toolRepository.findById(theId);

        Tool theTool = null;

        if (result.isPresent()) {
            theTool = result.get();
        } else {
            throw new RuntimeException("Did not find tool id " + theId);
        }
        return theTool;
    }
}
