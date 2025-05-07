package com.example.auction.controller;

import com.example.auction.entities.User;
import com.example.auction.service.UserService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "OK";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User entity) {
        User user = userService.getUserById(id);
        if (user == null)
            return "User not found";
        
        if (!id.equals(entity.getUsername())) {
            Logger logger = LoggerFactory.getLogger(UserController.class);
            logger.info("id :" + id);
            logger.info("username :" + entity.getUsername());
            return "Malfored Request";
        }

        userService.updateUser(id, entity);
        return "Updated";
    
    }
}
