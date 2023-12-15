package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        System.out.println(generalAuction.getHighBid().getBidder() + " is the winner!");

        ReserveAuction reserveAuction = new ReserveAuction("Remaining Altoids", 10);

        BuyoutAuction buyoutAuction = new BuyoutAuction( "recycling bin with trash", 15);
    }
}
