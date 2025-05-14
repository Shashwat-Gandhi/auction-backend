package com.example.auction.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.auction.entities.Auction;
import com.example.auction.repo.AuctionRepository;

@Service    
public class AuctionService {
    @Autowired
    private AuctionRepository auctionRepository;
    
    public Auction createAuction(Auction newAuction) {
        // validations to be put here, like checking the endTime
        return auctionRepository.save(newAuction);
    }
}
