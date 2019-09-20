package com.poiesis.api.controller;

import com.google.common.collect.Maps;
import com.poiesis.api.dto.UserDTO;
import com.poiesis.api.dto.responses.LoginResponseDTO;
import com.poiesis.api.model.User;
import com.poiesis.api.service.UserService;
import com.poiesis.api.utils.DTOUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    public String registerUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(DTOUtils.getUserFromDTO(userDTO));
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody UserDTO userDTO) {
        User userWithCredentials = userService.getUserWithCredentials(userDTO);
        String userToken = "";
        try{
            userToken = userService.getUserToken(userWithCredentials);
        }catch (Exception e){
            userToken = "invalid Username or Password";
        }
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.token = userToken;
        loginResponseDTO.name = userWithCredentials.getName();
        return loginResponseDTO;
    }

    @CrossOrigin(origins = "*")
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
