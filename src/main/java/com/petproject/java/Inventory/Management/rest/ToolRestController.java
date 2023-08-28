package com.petproject.java.Inventory.Management.rest;

import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToolRestController {

    private ToolService toolService;
    @Autowired
    public ToolRestController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping("/tools")
    public List<Tool> findAll(){
        return toolService.findAll();
    }
}
