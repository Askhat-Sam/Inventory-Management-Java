package com.petproject.java.Inventory.Management.controller;

import com.petproject.java.Inventory.Management.enntity.Tool;
import com.petproject.java.Inventory.Management.enntity.User;
import com.petproject.java.Inventory.Management.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        System.out.println(userList.get(0));

        String pw_hash = BCrypt.hashpw(userList.get(0).getPassword(), BCrypt.gensalt());

        System.out.println(pw_hash);

        return "users/admin-user";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public Optional<User> findByUserId(Integer theId) {
        System.out.println("The id for getUser: " + theId);
        return userService.findByUserId(theId);
    }
//    @RequestMapping(value="/updateUser", method = {RequestMethod.PUT, RequestMethod.GET})
//    public String updateUser(User theUser, HttpServletRequest request){
//
//        Tool updatedTool = userService.findById(theUser.getId());
//
//        userService.save(updatedTool);
//
//        return "redirect:/tools/admin-user";
//    }
}
