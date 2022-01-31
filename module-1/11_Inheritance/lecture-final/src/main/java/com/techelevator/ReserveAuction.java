package com.techelevator;

public class ReserveAuction extends Auction {
    private int reservePrice;
    private boolean isReservePriceMet;

    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = super.placeBid(offeredBid);

        if(offeredBid.getBidAmount() >= reservePrice) {
            isReservePriceMet = true;
        }

        return isCurrentWinningBid && isReservePriceMet;
    }

    @Override
    public Bid getHighBid() {
        if(isReservePriceMet) {
            return super.getHighBid();
        }

        return new Bid("", 0);
    }

    public int getReservePrice() {
        return reservePrice;
    }
}
