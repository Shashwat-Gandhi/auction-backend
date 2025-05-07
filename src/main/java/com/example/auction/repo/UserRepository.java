package com.example.auction.repo;

import com.example.auction.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    // Custom query methods can be added here
}
