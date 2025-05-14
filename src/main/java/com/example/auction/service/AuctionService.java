package com.example.auction.service;


import javax.persistence.EntityNotFoundException;

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

    public Auction updateAuction(Long id, Auction auction) {
        Auction auctionObj = auctionRepository.findById(id).orElseThrow(() ->  new EntityNotFoundException("Auction entity with id:" + id + " not found"));
        auctionObj.setName(auction.getName());
        auctionObj.setEndTime(auction.getEndTime());
        auctionObj.setStartTime(auction.getStartTime());
        auctionObj.setMinimumBidIncrements(auction.getMinimumBidIncrements());
        auctionObj.setStartingBid(auction.getStartingBid());

        return auctionRepository.save(auctionObj);
    }
}
