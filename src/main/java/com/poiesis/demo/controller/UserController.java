package com.poiesis.demo.controller;

import com.poiesis.demo.model.User;
import com.poiesis.demo.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String regiterUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/get")
    public User getUser(HttpServletRequest request) {
        ObjectId userId = (ObjectId) request.getAttribute("userId");
        return userService.getUser(userId);
    }

    @GetMapping("/")
    public User getAllUsers(HttpServletRequest request) {
        return userService.getAllUsers();
    }
}
