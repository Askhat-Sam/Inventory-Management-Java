package com.petproject.java.Inventory.Management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToolsController {
    //create a mapping for "/hello"
    @GetMapping("/tools")
    public String showList(Model theModel){
        theModel.addAttribute("theDate", new java.util.Date());
        return "list-tools";
    }


}
