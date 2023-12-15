package com.techelevator;

public class BuyoutAuction extends Auction{
private int buyoutPrice;
    public BuyoutAuction(String itemForSale, int bouyoutPrice) {
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        if (offeredBid.getBidAmount() >= buyoutPrice){
            ;
        }
        return super.placeBid(offeredBid);
    }
}
