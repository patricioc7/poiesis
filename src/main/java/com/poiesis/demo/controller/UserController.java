package com.poiesis.demo.controller;

import com.poiesis.demo.dto.UserDTO;
import com.poiesis.demo.model.User;
import com.poiesis.demo.service.UserService;
import com.poiesis.demo.utils.DTOUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String regiterUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(DTOUtils.getUserFromDTO(userDTO));
    }

    @GetMapping("/get")
    public User getUser(HttpServletRequest request) {
        ObjectId userId = (ObjectId) request.getAttribute("userId");
        return userService.getUser(userId);
    }

    @GetMapping("/")
    public List<User> getAllUsers(HttpServletRequest request) {
        return userService.getAllUsers();
    }
}
