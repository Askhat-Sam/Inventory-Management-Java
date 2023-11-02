package com.petproject.java.Inventory.Management.controller;

import com.petproject.java.Inventory.Management.enntity.Role;
import com.petproject.java.Inventory.Management.enntity.User;
import com.petproject.java.Inventory.Management.service.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/admin-user")
    public String showAdminUser(Model theModel){

        //Getting users with associated roles
        List<User> users = userService.findAll();

        //add users to model
        theModel.addAttribute("users",users);

        return "users/admin-user";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User findByUserId(Integer theId) {
        System.out.println("The id for getUser: " + theId);
        return userService.findByUserId(theId);
    }


    @RequestMapping(value="/updateUser", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateUser(User theUser){

        System.out.println("Updated user: " + theUser);

        userService.save(theUser);

        return "redirect:/users/admin-user";
    }

   @PostMapping("/addNewUser")
    public String addNewUser(@RequestParam("userId") String userId, @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName, @RequestParam("email") String email,
                             @RequestParam("password") String password, @RequestParam(value="checkbox1", required = false) String checkboxEmployee,
                             @RequestParam(value="checkbox2", required = false) String checkboxManager, @RequestParam(value="checkbox3", required = false) String checkboxAdmin) {
//       System.out.println("$$$$$$$ The value of checkbox 1: " + checkboxEmployee);
//       System.out.println("$$$$$$$ The value of checkbox 2: " + checkboxManager);
//       System.out.println("$$$$$$$ The value of checkbox 3: " + checkboxAdmin);

       //generate bcrypt hash
       String pw_hash = "{bcrypt}." + BCrypt.hashpw(password, BCrypt.gensalt());

       //create a new user
       User newUser = new User(userId, firstName, lastName, email, pw_hash);
       System.out.println(">>>>New user id: " + newUser.getId());

       //create new role
       Role tempRole = new Role(userId, "ROLE_EMPLOYEE");

       //add roles to the new user
       newUser.add(tempRole);

       System.out.println(">>>>>>>>>>>>>User to be added into DB: " + newUser);
       System.out.println(">>>>>>>>>>>>>Password: " + pw_hash);
        //save new user into db
       userService.update(newUser);

       return "redirect:/users/admin-user";
   }

   @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("theId") int theId){
       System.out.println(">>>>>>>>The user id to be deleted: " + theId);
        User userToBeDeleted = userService.findByUserId(theId);
        userService.deleteUserById(userToBeDeleted);

       return "redirect:/users/admin-user";
   }

}
