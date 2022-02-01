package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        Bid theBidToPlace = new Bid("Josh", 1);
        generalAuction.placeBid(theBidToPlace);

        //generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(theBidToPlace);
        System.out.println("Bid count: " + generalAuction.getAllBids().size() + " Current winning bidder: " + generalAuction.getHighBid().getBidder());

        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(theBidToPlace);
        System.out.println("Bid count: " + generalAuction.getAllBids().size() + " Current winning bidder: " + generalAuction.getHighBid().getBidder());


        generalAuction.placeBid(theBidToPlace);
        System.out.println("Bid count: " + generalAuction.getAllBids().size() + " Current winning bidder: " + generalAuction.getHighBid().getBidder());generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        List<Bid> allBids = new ArrayList<>();
        allBids.add(new Bid("Test", 5));

        for(Bid bid : allBids) {
            System.out.println(bid.getBidder() + " " + bid.getBidAmount());
        }

        System.out.println();



        myReserveAuction.placeBid(new Bid("Josh", 1));
        System.out.println("Bid count: " + generalAuction.getAllBids().size() + " Current winning bidder: " + generalAuction.getHighBid().getBidder());generalAuction.placeBid(new Bid("Rick Astley", 13));
        myReserveAuction.placeBid(new Bid("Fonz", 43));
        System.out.println("Bid count: " + generalAuction.getAllBids().size() + " Current winning bidder: " + generalAuction.getHighBid().getBidder());generalAuction.placeBid(new Bid("Rick Astley", 13));
        myReserveAuction.placeBid(new Bid("Billie", 41);
        System.out.println("Bid count: " + generalAuction.getAllBids().size() + " Current winning bidder: " + generalAuction.getHighBid().getBidder());generalAuction.placeBid(new Bid("Rick Astley", 13));
        myReserveAuction.placeBid(new Bid("Oliver", 100);
        System.out.println("Bid count: " + generalAuction.getAllBids().size() + " Current winning bidder: " + generalAuction.getHighBid().getBidder());generalAuction.placeBid(new Bid("Rick Astley", 13));




        ReserveAuction myReserveAuction = new ReserveAuction("Tech Elevator Backpack", 40);


    }
}
