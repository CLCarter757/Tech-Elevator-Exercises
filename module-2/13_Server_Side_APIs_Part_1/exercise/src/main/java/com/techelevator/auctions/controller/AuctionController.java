package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> list( @RequestParam(required = false, name = "title_like", defaultValue = "") String title,
                               @RequestParam(required = false, name = "currentBid_lte", defaultValue = "0") double currentBid) {
        List<Auction> auctions = dao.list();
        List<Auction> filteredAuctions = new ArrayList<>();

        if(!title.equals("") && currentBid == 0) {
            filteredAuctions = dao.searchByTitle(title);
            return filteredAuctions;
        }
        if (title.equals("") && currentBid > 0) {
            filteredAuctions = dao.searchByPrice(currentBid);
            return filteredAuctions;
        }
        if (!title.equals("") && currentBid > 0) {
            filteredAuctions = dao.searchByTitleAndPrice(title, currentBid);
            return filteredAuctions;
        }
        
        return auctions;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
        return dao.create(auction);
    }



}
