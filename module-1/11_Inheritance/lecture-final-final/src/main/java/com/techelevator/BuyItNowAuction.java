package com.techelevator;

public class BuyItNowAuction extends Auction {
    private int buyItNowPrice;
    private boolean isAlreadyBought;

    public BuyItNowAuction(String itemForSale, int buyItNowPrice) {
        super(itemForSale);
        this.buyItNowPrice = buyItNowPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        if(isAlreadyBought) {
            return false;
        }

        if(!isAlreadyBought && offeredBid.getBidAmount() >= buyItNowPrice) {
            offeredBid = new Bid(offeredBid.getBidder(), buyItNowPrice);
            isAlreadyBought = true;
        }

        return super.placeBid(offeredBid);

    }

    public int getBuyItNowPrice() {
        return buyItNowPrice;
    }
}
