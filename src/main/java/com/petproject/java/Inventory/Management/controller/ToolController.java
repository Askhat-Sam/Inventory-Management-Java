package com.petproject.java.Inventory.Management.controller;

import com.petproject.java.Inventory.Management.enntity.Search;
import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.enntity.Transaction;
import com.petproject.java.Inventory.Management.enntity.User;
import com.petproject.java.Inventory.Management.service.ToolService;
import com.petproject.java.Inventory.Management.service.TransactionService;
import com.petproject.java.Inventory.Management.service.UserService;
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
import java.util.Optional;

@Controller
@RequestMapping("/tools")
public class ToolController {
    @Value("${headers}")
    private List<String> theHeaders;
    private ToolService toolService;

    private UserService userService;
    @Autowired
    private TransactionService transactionService;

    public ToolController(ToolService toolService, TransactionService transactionService, UserService userService) {
        this.toolService = toolService;
        this.transactionService = transactionService;
        this.userService =userService;
    }

    @RequestMapping("/list")
    public String listTools(Model theModel, @Param("keyword") String keyword, @Param("option")  String option){
        Search theSearch = new Search();
//        System.out.println("The headers" + theHeaders);
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

    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel){
        //create model attribute to bind form data
        Tool theTool = new Tool();

        theModel.addAttribute("tool", theTool);

        return "tools/tool-form";
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
        Tool deletedTool = toolService.findById(theId);
        Transaction deleteTransaction = new Transaction(
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
                        SecurityContextHolder.getContext().getAuthentication().getName(),
                        deletedTool.getId(),
                        "Tool with id '" + theId + "' was removed."
        );
        transactionService.save(deleteTransaction);
        toolService.deleteById(theId);
        return "redirect:/tools/list";
    }

    @PostMapping("/addNew")
    public String addTool(@RequestParam("partNumber") String partNumber, @RequestParam("serialNumber") String serialNumber,
                          @RequestParam("description") String description, @RequestParam("location") String location){
        //create new tool object
        Tool theTool = new Tool(partNumber, serialNumber, description, location);
//TOOOOOOOOOOOOOOOOOOOO BE FIXED why adding tool cannot be dispalayed in tracsactions list######################################################################33
//        System.out.println("Updated tool - " +updatedTool);
//        //create transaction object
//        List<Transaction> transactionList = new ArrayList<>();
//        Transaction transaction = new Transaction();
//        if (!updatedTool.equals(theTool)){
//            if (!updatedTool.getPartNumber().equals(theTool.getPartNumber())){
//                transactionList.add(
//                        new Transaction(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
//                                SecurityContextHolder.getContext().getAuthentication().getName(),
//                                theTool.getId(),
//                                updatedTool.getPartNumber().equals(theTool.getPartNumber()) ? "" : "Part number was changed from: '" + updatedTool.getPartNumber() + "' to '" + theTool.getPartNumber() + "'"
//                        )
//                );
//            }
//            if (!updatedTool.getSerialNumber().equals(theTool.getSerialNumber())){
//                transactionList.add(
//                        new Transaction(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
//                                SecurityContextHolder.getContext().getAuthentication().getName(),
//                                theTool.getId(),
//                                updatedTool.getSerialNumber().equals(theTool.getSerialNumber()) ? "" : "Serial number was changed from: '" + updatedTool.getSerialNumber() + "' to '" + theTool.getSerialNumber() + "'"
//                        )
//                );
//            }
//            if (!updatedTool.getDescription().equals(theTool.getDescription())){
//                transactionList.add(
//                        new Transaction(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
//                                SecurityContextHolder.getContext().getAuthentication().getName(),
//                                theTool.getId(),
//                                updatedTool.getDescription().equals(theTool.getDescription()) ? "" : "Description was changed from: " + updatedTool.getDescription() + "' to '" + theTool.getDescription() + "'"
//                        )
//                );
//            }
//            if (!updatedTool.getLocation().equals(theTool.getLocation())){
//                transactionList.add(
//                        new Transaction(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()),
//                                SecurityContextHolder.getContext().getAuthentication().getName(),
//                                theTool.getId(),
//                                updatedTool.getLocation().equals(theTool.getLocation()) ? "" : "Location was changed from: '" + updatedTool.getLocation() + "' to '" + theTool.getLocation() + "'"
//                        )
//                );
//            }
//        }
//        //update DB if there were changes in tools list
//        if (transactionList.size()>0){
//            transactionList.forEach(s->transactionService.save(s));
//            System.out.println("Transaction database was updated");
//        }
        //save the new tool
        toolService.save(theTool);

        //use a redirect to prevent duplicate submission
        return "redirect:/tools/list";
    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Tool theTool, HttpServletRequest request){
//        System.out.println("Tool from the modal form - " + theTool);
        Tool updatedTool = toolService.findById(theTool.getId());
//        System.out.println("Updated tool - " +updatedTool);
        //create transaction object
        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction = new Transaction();
//          System.out.println(transactionListAspect);
        System.out.println("Controller before save");
        toolService.save(theTool);
        System.out.println("Controller after save");
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



    @RequestMapping("/admin-user")
    public String showAdminUser(Model theModel){
        List<User> userList = userService.findAll();
//        System.out.println("This is the user list: " + userList);
        theModel.addAttribute("users", userList);
        return "tools/admin-user";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public Optional<User> findByUserId(Integer theId) {
        System.out.println("The id for getUser: " + theId);
        return userService.findByUserId(theId);
    }
    @RequestMapping(value="/updateUser", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateUser(User theUser, HttpServletRequest request){

        Tool updatedTool = toolService.findById(theUser.getId());

        toolService.save(updatedTool);

        return "redirect:/tools/admin-user";
    }
}
