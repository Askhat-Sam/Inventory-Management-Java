package com.petproject.java.Inventory.Management.controller;

import com.petproject.java.Inventory.Management.dao.ToolRepository;
import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.service.ToolService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tools")
public class ToolController {
    private ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @RequestMapping("/list")
    public String listTools(Model theModel, @Param("keyword") String keyword, @Valid String option){
        System.out.println("this is from select "+ option);
        List<Tool> theTools = toolService.findAll(keyword);
        theModel.addAttribute("tools", theTools);
        theModel.addAttribute("keyword", keyword);
        return "tools/list-tools";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel){
        //create model attribute to bind form data
        Tool theTool = new Tool();
        theModel.addAttribute("tool", theTool);
        return "tools/tool-form";
    }

    @PostMapping("/save")
    public String saveTool(@Valid @ModelAttribute("tool") Tool theTool, BindingResult theBindingResult){
        if (theBindingResult.hasErrors()){
            return "tools/tool-form";
        }
        //save tool
        toolService.save(theTool);
        //use a redirect to prevent dublicate submission
        return "redirect:/tools/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("toolId") int theId, Model theModel){

        //get tool from database
        Tool theTool = toolService.findById(theId);
        //set tool as a model attribute to the pre-populate form
        theModel.addAttribute("tool", theTool);

        //send over to form
        return "tools/tool-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("toolId") int theId){
        toolService.deleteById(theId);
        return "redirect:/tools/list";
    }

}
