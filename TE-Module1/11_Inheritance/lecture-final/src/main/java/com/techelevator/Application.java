package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        Bid fonzBid = new Bid("Fonz", 23);
        generalAuction.placeBid(fonzBid);
        generalAuction.placeBid(new Bid("Rick Astley", 33));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        System.out.println(generalAuction.getHighBid().getBidder() + " is the winner!");

        ReserveAuction reserveAuction = new ReserveAuction("Remaining Altoids", 10);
        reserveAuction.placeBid(new Bid("Roland", 1));
        reserveAuction.placeBid(new Bid("Anisa", 15));
        reserveAuction.placeBid(new Bid("Leul", 11));
        System.out.println(reserveAuction.getHighBid().getBidder() + " is the winner");


        BuyoutAuction buyoutAuction = new BuyoutAuction("recycling bin with trash bag!", 15);
        buyoutAuction.placeBid(new Bid("Kayla", 16));
        buyoutAuction.placeBid(new Bid("Max", 17));
        buyoutAuction.placeBid(new Bid("Aidan", 4));

        for (Bid currentBid:buyoutAuction.getAllBids()){
            System.out.println(currentBid.getBidder() + " with bid: " + currentBid.getBidAmount());
        }
        System.out.println(buyoutAuction.getHighBid().getBidder() + " is the winner with a bid of " + buyoutAuction.getHighBid().getBidAmount());

        List<Auction> auctions = new ArrayList<>();
        auctions.add(generalAuction);
        auctions.add(reserveAuction);
        auctions.add(buyoutAuction);

        for(Auction currentAuction : auctions){
            currentAuction.placeBid(new Bid("Testing Bid", 40));
            System.out.println(currentAuction.getHighBid().getBidder() + " won with a bid of : " + currentAuction.getHighBid().getBidAmount());
        }
    }
}
