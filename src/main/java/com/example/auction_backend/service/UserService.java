package com.example.auction_backend.service;

import javax.persistence.*;
import com.example.auction_backend.repository.UserRepository;
import com.example.auction_backend.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public boolean addUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername()).orElse(null);
        if (existingUser != null) {
            return false;
        }

        existingUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        if (existingUser != null) {
            return false;
        }
        userRepository.save(user);
        return true;
    }
}