package com.petproject.java.Inventory.Management.controller;

import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.enntity.User;
import com.petproject.java.Inventory.Management.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/admin-user")
    public String showAdminUser(Model theModel){
        List<User> userList = userService.findAll();
//        System.out.println("This is the user list: " + userList);
        theModel.addAttribute("users", userList);
//        System.out.println(userList.get(0));
//
        String pw_hash = BCrypt.hashpw(userList.get(0).getPassword(), BCrypt.gensalt());

//        System.out.println(pw_hash);

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
                             @RequestParam("password") String password) {

       System.out.println(">>>>>>>>>>>>>UserID to be added into DB: " + userId);
        User newUser = new User(userId, firstName, lastName, email, password);

       System.out.println(">>>>>>>>>>>>>User to be added into DB: " + newUser);

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
