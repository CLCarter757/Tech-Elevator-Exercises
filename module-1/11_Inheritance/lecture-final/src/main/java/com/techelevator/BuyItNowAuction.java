package com.techelevator;

public class BuyItNowAuction extends Auction{
    private int buyItNOwPrice;
    private boolean isAlreadyBought;

    public BuyItNowAuction(String itemForSale, int buyItNOwPrice) {
        super(itemForSale);
        this.buyItNOwPrice = buyItNOwPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        if(isAlreadyBought) {
            return false;
        }

        if(!isAlreadyBought && offeredBid.getBidAmount() >= buyItNOwPrice) {
            offeredBid = new Bid(offeredBid.getBidder(), buyItNOwPrice);
            isAlreadyBought = true;
        }

        return super.placeBid(offeredBid);
    }

    public int getBuyItNOwPrice() {
        return buyItNOwPrice;
    }
}
