package com.poiesis.demo.controller;

import com.poiesis.demo.model.User;
import com.poiesis.demo.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody User user) {
        user.set_id(id);
        repository.save(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User createUser(@Valid @RequestBody User user) {
        user.set_id(ObjectId.get());
        repository.save(user);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}
