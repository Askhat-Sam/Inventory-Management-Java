package com.petproject.java.Inventory.Management.controller;

import org.springframework.stereotype.Controller;
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
