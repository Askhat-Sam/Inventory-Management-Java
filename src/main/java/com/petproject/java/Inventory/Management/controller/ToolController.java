package com.petproject.java.Inventory.Management.controller;

import com.petproject.java.Inventory.Management.dao.ToolRepository;
import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.service.ToolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tools")
public class ToolController {
    private ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping("/list")
    public String listTools(Model theModel){
        //get tools from database
        List<Tool> theTools = toolService.findAll();
        //add to the spring model
        theModel.addAttribute("tools", theTools);

        return "tools/list-tools";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel){
        //create model attribute to bind form data
        Tool theTool = new Tool();
        theModel.addAttribute("tool", theTool);
        return "tools/tool-form";
    }
}
