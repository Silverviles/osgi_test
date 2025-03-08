package org.sa.manager;


import java.util.ArrayList;
import java.util.List;

public class Auction {
    private AuctionItem auctionItem;
    private List<Bid> bids;
    private boolean isActive;

    public Auction(AuctionItem auctionItem) {
        this.auctionItem = auctionItem;
        this.bids = new ArrayList<>();
        this.isActive = true;
    }

    public AuctionItem getAuctionItem() {
        return auctionItem;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public boolean isActive() {
        return isActive;
    }

    public void addBid(Bid bid) {
        this.bids.add(bid);
    }

    public void endAuction() {
        this.isActive = false;
    }

    /**
     * Utility method to get the highest bid.
     */
    public Bid getHighestBid() {
        return bids.stream()
                   .max((b1, b2) -> Double.compare(b1.getAmount(), b2.getAmount()))
                   .orElse(null);
    }
}
