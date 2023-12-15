package com.techelevator;

public class ReserveAuction extends Auction{

    private int reservePrice;

    public ReserveAuction(String itemForSale, int reservePrice) {
        //super will do eveything from the other constructor in parent then anything new below it
        super(itemForSale);
        //do super first then set anything else needed
        this.reservePrice = reservePrice;
    }

    //need to override the placeBid method.  can ricght click and use generate override
    @Override
    public boolean placeBid(Bid offeredBid) {
        return super.placeBid(offeredBid);
    }
}
