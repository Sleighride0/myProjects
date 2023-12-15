package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }

    @RequestMapping (method = RequestMethod.GET)
    public List<Auction> list(@RequestParam (required = false) String title_like, @RequestParam(defaultValue = "0.00", required = false) double currentBid_lte){
        // making the currentBid_lte as a Double (capital D) using a wrapper. Double needs a 'not null comparison rather than >0)
        if (title_like != null && currentBid_lte > 0){
            return auctionDao.getAuctionsByTitleAndMaxBid(title_like, currentBid_lte);
        } else if (title_like != null) {
            return auctionDao.getAuctionsByTitle(title_like);
        } else if (currentBid_lte > 0) {
              return auctionDao.getAuctionsByMaxBid(currentBid_lte);
        } else
        return auctionDao.getAuctions();
    }
    @RequestMapping("/{id}")
    public Auction get(@PathVariable int id){
        return auctionDao.getAuctionById(id);
    }
    @RequestMapping (method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction){
        return auctionDao.createAuction(auction);
    }
}
