package com.petproject.java.Inventory.Management.controller;

import com.petproject.java.Inventory.Management.service.ToolService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
//    private ToolService toolService;
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "new-login";
    }

    //add request mapping for access denied
    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        return "access-denied";
    }
}
