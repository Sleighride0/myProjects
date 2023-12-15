package com.techelevator;

public class BuyoutAuction extends Auction{
    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
//        an additional set price (the 'buyout' price) that any bidder
//        can accept at any time during the auction, thereby immediately ending the auction and winning the item.
        //care about the current winning bid
        boolean isCurrentWinningBid = false;
        if(getHighBid().getBidAmount() < buyoutPrice){
            if(buyoutPrice <= offeredBid.getBidAmount()){
                    offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
            }
            isCurrentWinningBid = super.placeBid(offeredBid);
        }

        return isCurrentWinningBid;
    }
}
