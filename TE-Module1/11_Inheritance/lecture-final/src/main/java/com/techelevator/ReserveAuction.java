package com.techelevator;

public class ReserveAuction extends Auction{

    private int reservePrice;

    public ReserveAuction(String reserveItemForSale, int reservePrice) {
        super(reserveItemForSale);
        this.reservePrice = reservePrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        //offeredBid getAmount must meet my reserve price
        if(offeredBid.getBidAmount() >= reservePrice){
            return super.placeBid(offeredBid);
        }
       return false;
    }
}
