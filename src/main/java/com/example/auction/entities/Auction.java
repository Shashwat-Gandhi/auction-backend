package com.example.auction.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.PostMapping;

import ch.qos.logback.core.joran.event.BodyEvent;
import lombok.Data;

@Data
@Entity
@Table(name="auctioons")
public class Auction {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int startingBid;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int minimumBidIncrements;
    
}
