package com.petproject.java.Inventory.Management.rest;

import com.petproject.java.Inventory.Management.dao.ToolDao;
import com.petproject.java.Inventory.Management.enntity.Tool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToolRestController {

    private ToolDao toolDao;

    public ToolRestController(ToolDao theToolDao) {
        this.toolDao = theToolDao;
    }

    @GetMapping("/tools")
    public List<Tool> findAll(){
        return toolDao.findAll();
    }
}
