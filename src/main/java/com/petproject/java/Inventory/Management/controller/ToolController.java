package com.petproject.java.Inventory.Management.controller;

import com.petproject.java.Inventory.Management.enntity.Search;
import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.enntity.Transaction;
import com.petproject.java.Inventory.Management.service.ToolService;
import com.petproject.java.Inventory.Management.service.TransactionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tools")
public class ToolController {
    @Value("${headers}")
    private List<String> theHeaders;
    private ToolService toolService;

    @Autowired
    private TransactionService transactionService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @RequestMapping("/list")
    public String listTools(Model theModel, @Param("keyword") String keyword, @Param("option")  String option){
        Search theSearch = new Search();
//        System.out.println("The headers" + theHeaders);
        List<Tool> theTools = toolService.findAll(keyword);

        Tool tool2 = new Tool();
        theModel.addAttribute(tool2);

        List<Tool> filteredTools = new ArrayList<>();
//        System.out.println(theTools);
        if (option!=null){
            switch(option) {
                case "Id":
                    for (Tool tool: theTools) {
                        if (String.valueOf(tool.getBarcodeId()).contains(keyword)){
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
        theModel.addAttribute("headers", theHeaders);
        theModel.addAttribute("search", theSearch);

        return "tools/list-tools";
    }

    @RequestMapping("/transactions")
    public String transactionHistory(Model theModel, @Param("keyword") String keyword, @Param("option")  String option){
        List<Transaction> theTransactions = transactionService.findAll(keyword);
//        System.out.println(":Option:" + option);
        System.out.println("Transactions from SQL " + theTransactions);
        theModel.addAttribute("transactions", theTransactions);
        return "tools/transactions-history";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("toolId") int theId){
        Tool deletedTool = toolService.findById(theId);
        Transaction deleteTransaction = new Transaction(
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
                        SecurityContextHolder.getContext().getAuthentication().getName(),
                        deletedTool.getBarcodeId(),
                        "Tool with id '" + theId + "' was removed."
        );
        transactionService.save(deleteTransaction);
        toolService.deleteById(theId);
        return "redirect:/tools/list";
    }

    @GetMapping("/addNew")
    public String addNewTool(Tool tool){
        toolService.update(tool);
        return "redirect:/tools/list";
    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Tool theTool, HttpServletRequest request){
        Tool updatedTool = toolService.findById(theTool.getBarcodeId());

        //create transaction object
        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction = new Transaction();

        toolService.save(theTool);
        ArrayList<Transaction> transactionListAspect = (ArrayList<Transaction>) request.getAttribute("transactionList2");

        //update DB if there were changes in tools list
        System.out.println("Transaction list from controller" +  transactionListAspect);
        if (transactionListAspect.size()>0){
            transactionListAspect.forEach(s->transactionService.save(s));
            System.out.println("Transaction database was updated");
        }
        return "redirect:/tools/list";
    }
    @RequestMapping("/getOne")
    @ResponseBody
    public Tool findById(Integer theId){
        return toolService.findById(theId);
    }

}
