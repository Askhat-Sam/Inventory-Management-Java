package com.petproject.java.Inventory.Management.rest;

import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //reading a single tool
    @GetMapping("/tools/{toolId}")
    public Tool getTool(@PathVariable int toolId) {
        Tool theTool = toolService.findById(toolId);

        if (theTool == null){
            throw new RuntimeException("Tool id not found " + toolId);
        }
        return theTool;
    }

    @PostMapping("/tools")
    public Tool addTool(@RequestBody Tool theTool){
        theTool.setId(0);
        Tool dbTool = toolService.save(theTool);

        return  dbTool;
    }

    @PutMapping("/tools")
    public Tool updateTool(@RequestBody Tool theTool){
        Tool dbTool = toolService.save(theTool);

        return  dbTool;
    }

//    @DeleteMapping("/tool/{toolId}")
//    public void deleteTool(@PathVariable int toolId){
//      toolService.deleteById(toolId);
//    }
}
