package com.petproject.java.Inventory.Management.controller;

import com.petproject.java.Inventory.Management.enntity.Role;
import com.petproject.java.Inventory.Management.enntity.Transaction;
import com.petproject.java.Inventory.Management.enntity.User;
import com.petproject.java.Inventory.Management.service.ToolService;
import com.petproject.java.Inventory.Management.service.TransactionService;
import com.petproject.java.Inventory.Management.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private ToolService toolService;

    private TransactionService transactionService;

    public UserController(UserService userService, ToolService toolService, TransactionService transactionService) {
        this.userService = userService;
        this.toolService = toolService;
        this.transactionService = transactionService;
    }

    @RequestMapping("/admin-user")
    public String showAdminUser(Model theModel){

        //Getting users with associated roles
        List<User> users = userService.findAll();

        //add users to model
        theModel.addAttribute("users",users);

        return "users/admin-user";
    }

//    @RequestMapping("/getUser")
//    @ResponseBody
//    public User findById(Integer theId) {
//        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$ " + userService.findById(theId));
////        return userService.findById(theId);
//        return  userService.findById(theId);
//    }
    @RequestMapping("/getUser")
    @ResponseBody
    public User findById(Integer theId) {
        System.out.println("HERE: " + userService.findById(theId));
        return userService.findById(theId);
    }

//    @RequestMapping(value="/updateUser", method = {RequestMethod.PUT, RequestMethod.GET})
//    public String updateUser(User theUser){
//
//        System.out.println("Updated user: " + theUser);
//
////        userService.save(theUser);
//
//        return null;
//    }
    @PostMapping("/updateUser")
    public void updateUser(@RequestParam("userId") String userId, @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName, @RequestParam("email") String email,
                             @RequestParam("password") String password, @RequestParam(value="checkbox1", required = false) String checkboxEmployee,
                             @RequestParam(value="checkbox2", required = false) String checkboxManager, @RequestParam(value="checkbox3", required = false) String checkboxAdmin){

    }

   @PostMapping("/addNewUser")
    public String addNewUser(@RequestParam("userId") String userId, @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName, @RequestParam("email") String email,
                             @RequestParam("password") String password, @RequestParam(value="checkbox1", required = false) String checkboxEmployee,
                             @RequestParam(value="checkbox2", required = false) String checkboxManager, @RequestParam(value="checkbox3", required = false) String checkboxAdmin) {
       System.out.println("$$$$$$$ The value of checkbox 1: " + checkboxEmployee);
       System.out.println("$$$$$$$ The value of checkbox 2: " + checkboxManager);
       System.out.println("$$$$$$$ The value of checkbox 3: " + checkboxAdmin);

       //generate bcrypt hash
       String pw_hash = "{bcrypt}" + BCrypt.hashpw(password, BCrypt.gensalt());

       //create a new user
       User newUser = new User(userId, firstName, lastName, email, pw_hash, 1);

        //add roles to user
        for (String checkbox : new String[]{checkboxEmployee, checkboxManager, checkboxAdmin}) {
            if (checkbox!=null){
                newUser.add(new Role(userId, checkbox));
            }
        }

        //save new user into db
       userService.update(newUser);

       return "redirect:/users/admin-user";
   }

   @GetMapping("/deleteUser")
//   @ResponseBody
    public String deleteUser(@RequestParam("theId") int theId){
       System.out.println(">>>>>>>>The user id to be deleted: " + theId);
        User userToBeDeleted = userService.findById(theId);
       System.out.println(">>>>>>>>The user id to be deleted: " + userToBeDeleted);

        userService.deleteUserById(userToBeDeleted);

//        return userService.findById(theId);
       return "redirect:/users/admin-user";
   }

    @RequestMapping("/transactions")
    public String transactionHistory(Model theModel, @Param("keyword") String keyword, @Param("option")  String option){
        List<Transaction> theTransactions = transactionService.findAll(keyword);

        System.out.println("Transactions from SQL " + theTransactions);
        theModel.addAttribute("transactions", theTransactions);
        return "users/transactions-history-user";
    }

}
