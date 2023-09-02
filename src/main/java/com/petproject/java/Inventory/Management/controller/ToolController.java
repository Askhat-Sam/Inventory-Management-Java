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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tools")
public class ToolController {
    private ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @RequestMapping("/list")
    public String listTools(Model theModel, @Param("keyword") String keyword, @Param("option")  String option){
        System.out.println("Selected option "+ option);

        List<Tool> theTools = toolService.findAll(keyword);
        List<Tool> filteredTools = new ArrayList<>();
//        System.out.println(theTools);
        if (option!=null){
            switch(option) {
                case "Id":
                    for (Tool tool: theTools) {
                        if (String.valueOf(tool.getId()).contains(keyword)){
                            filteredTools.add(tool);
                        }
                    }
                    theModel.addAttribute("tools", filteredTools);
                    theModel.addAttribute("keyword", keyword); // to keep  previously selected option
                    theModel.addAttribute("option", option); // to keep  previous input in search input box
                    return "tools/list-tools";
                case "Part Number":
                    for (Tool tool: theTools) {
                        if (String.valueOf(tool.getPartNumber()).contains(keyword)){
                            filteredTools.add(tool);
                        }
                    }
                    theModel.addAttribute("tools", filteredTools);
                    theModel.addAttribute("keyword", keyword); // to keep  previous input in search input box
                    theModel.addAttribute("option", option); // to keep  previous input in search input box
                    return "tools/list-tools";
                case "Serial Number":
                    for (Tool tool: theTools) {
                        if (String.valueOf(tool.getSerialNumber()).contains(keyword)){
                            filteredTools.add(tool);
                        }
                    }
                    theModel.addAttribute("tools", filteredTools);
                    theModel.addAttribute("keyword", keyword);
                    theModel.addAttribute("option", option); // to keep  previous input in search input box
                    return "tools/list-tools";
                case "Description":
                    for (Tool tool: theTools) {
                        if (String.valueOf(tool.getDescription()).contains(keyword)){
                            filteredTools.add(tool);
                            System.out.println(filteredTools);
                        }
                    }
                    theModel.addAttribute("tools", filteredTools);
                    theModel.addAttribute("keyword", keyword);
                    theModel.addAttribute("option", option); // to keep  previous input in search input box
                    return "tools/list-tools";
                case "Location":
                    for (Tool tool: theTools) {
                        if (String.valueOf(tool.getLocation()).contains(keyword)){
                            filteredTools.add(tool);
                            System.out.println(filteredTools);
                        }
                    }
                    theModel.addAttribute("tools", filteredTools);
                    theModel.addAttribute("keyword", keyword);
                    theModel.addAttribute("option", option); // to keep  previous input in search input box
                    return "tools/list-tools";
                default:
                    // code block
            }
        }

        theModel.addAttribute("tools", theTools);
        theModel.addAttribute("keyword", keyword); // to keep  previously selected option
        theModel.addAttribute("option", option); // to keep  previous input in search input box
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
        //use a redirect to prevent duplicate submission
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
