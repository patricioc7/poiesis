package com.poiesis.api.service;

import com.poiesis.api.dto.UserDTO;
import com.poiesis.api.model.User;
import com.poiesis.api.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private TokenService tokenService;

    @Autowired
    UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User getUser(ObjectId userId) {
        Optional<User> byId = userRepository.findById(userId);
        return byId.get();
    }

    public String saveUser(User user) {
        User savedUser = userRepository.save(user);
        return tokenService.createToken(savedUser.getId());
    }

    public String getUserToken(User user) {
        return tokenService.createToken(user.getId());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserWithCredentials(UserDTO userDTO) {
       return userRepository.findByEmailAndPassword(userDTO.email, userDTO.password);
    }
}