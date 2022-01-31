package com.techelevator;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");


        Bid theBidToPlace = new Bid("Josh", 1);
        generalAuction.placeBid(theBidToPlace);
        System.out.println("Bid count: " + generalAuction.getAllBids().size() + " Current winning bidder: " + generalAuction.getHighBid().getBidder());

        generalAuction.placeBid(new Bid("Fonz", 23));
        System.out.println("Bid count: " + generalAuction.getAllBids().size() + " Current winning bidder: " + generalAuction.getHighBid().getBidder());


        generalAuction.placeBid(new Bid("Rick Astley", 13));
        System.out.println("Bid count: " + generalAuction.getAllBids().size() + " Current winning bidder: " + generalAuction.getHighBid().getBidder());

        System.out.println();
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids



        /*
        Proving why getter for allBids needs new ArrayList
         */
        List<Bid> allBids = generalAuction.getAllBids();

        allBids.add(new Bid("Test", 5));

        for(Bid bid : allBids) {
            System.out.println(bid.getBidder() + " " + bid.getBidAmount());
        }

        System.out.println();

        allBids = generalAuction.getAllBids();

        for(Bid bid : allBids) {
            System.out.println(bid.getBidder() + " " + bid.getBidAmount());
        }



        ReserveAuction myReserveAuction = new ReserveAuction("Tech Elevator Backpack", 40);

        myReserveAuction.placeBid(new Bid("Josh", 1));
        System.out.println("Bid count: " + myReserveAuction.getAllBids().size() + " Current winning bidder: " + myReserveAuction.getHighBid().getBidder());

        myReserveAuction.placeBid(new Bid("Fonz", 43));
        System.out.println("Bid count: " + myReserveAuction.getAllBids().size() + " Current winning bidder: " + myReserveAuction.getHighBid().getBidder());

        myReserveAuction.placeBid(new Bid("Billie", 41));
        System.out.println("Bid count: " + myReserveAuction.getAllBids().size() + " Current winning bidder: " + myReserveAuction.getHighBid().getBidder());

        myReserveAuction.placeBid(new Bid("Oliver", 100));
        System.out.println("Bid count: " + myReserveAuction.getAllBids().size() + " Current winning bidder: " + myReserveAuction.getHighBid().getBidder());


        System.out.println();

        BuyItNowAuction myBuyItNowAuction = new BuyItNowAuction("Tech Elevator Mug", 15);

        myBuyItNowAuction.placeBid(new Bid("Josh", 5));
        System.out.println("Bid count: " + myBuyItNowAuction.getAllBids().size() + " Current winning bidder: " + myBuyItNowAuction.getHighBid().getBidder() + " Bid amount: " + myBuyItNowAuction.getHighBid().getBidAmount());

        myBuyItNowAuction.placeBid(new Bid("Fonz", 12));
        System.out.println("Bid count: " + myBuyItNowAuction.getAllBids().size() + " Current winning bidder: " + myBuyItNowAuction.getHighBid().getBidder() + " Bid amount: " + myBuyItNowAuction.getHighBid().getBidAmount());

        myBuyItNowAuction.placeBid(new Bid("Billie", 16));
        System.out.println("Bid count: " + myBuyItNowAuction.getAllBids().size() + " Current winning bidder: " + myBuyItNowAuction.getHighBid().getBidder() + " Bid amount: " + myBuyItNowAuction.getHighBid().getBidAmount());

        myBuyItNowAuction.placeBid(new Bid("Oliver", 100));
        System.out.println("Bid count: " + myBuyItNowAuction.getAllBids().size() + " Current winning bidder: " + myBuyItNowAuction.getHighBid().getBidder() + " Bid amount: " + myBuyItNowAuction.getHighBid().getBidAmount());

    }
}
