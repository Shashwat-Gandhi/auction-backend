package com.example.auction.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auction.entities.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long>{
    
}
