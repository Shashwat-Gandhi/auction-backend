package com.example.auction.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auction.entities.Auction;
import com.example.auction.service.AuctionService;

@RestController
@RequestMapping("/auctions")
public class AuctionController {
    @Autowired
    private AuctionService auctionService;

    Logger logger = LoggerFactory.getLogger(AuctionController.class);

    @PostMapping("/create")
    ResponseEntity<Object> createAuction(@RequestBody Auction auction) {
        logger.info("request entity " + auction.getEndTime() + " name: " + auction.getName());
        Auction createdAuction = auctionService.createAuction(auction);
        return new ResponseEntity<Object>("Hi", HttpStatus.CREATED);
    }
}
