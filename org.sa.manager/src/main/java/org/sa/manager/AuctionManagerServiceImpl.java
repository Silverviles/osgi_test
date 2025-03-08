package org.sa.manager;
import java.util.HashMap;
import java.util.Map;

public class AuctionManagerServiceImpl implements AuctionManagerService {
    
    // A simple in-memory store mapping itemId -> Auction
    private final Map<String, Auction> auctions = new HashMap<>();
    
    @Override
    public void createAuction(AuctionItem item) {
        if (item == null || auctions.containsKey(item.getItemId())) {
            System.out.println("Auction already exists or item is invalid.");
            return;
        }
        Auction newAuction = new Auction(item);
        auctions.put(item.getItemId(), newAuction);
        System.out.println("Auction created for item: " + item.getItemName());
    }

    @Override
    public void placeBid(String itemId, Bid bid) {
        Auction auction = auctions.get(itemId);
        if (auction == null || !auction.isActive()) {
            System.out.println("Cannot place bid. Auction not found or inactive.");
            return;
        }
        auction.addBid(bid);
        System.out.println("Bid placed by " + bid.getBidderId() + " with amount " + bid.getAmount());
    }

    @Override
    public Auction getAuction(String itemId) {
        return auctions.get(itemId);
    }

    @Override
    public void endAuction(String itemId) {
        Auction auction = auctions.get(itemId);
        if (auction != null && auction.isActive()) {
            auction.endAuction();
            System.out.println("Auction ended for item: " + auction.getAuctionItem().getItemName());
            Bid highestBid = auction.getHighestBid();
            if (highestBid != null) {
                System.out.println("Winning bidder: " + highestBid.getBidderId() 
                                   + " with amount " + highestBid.getAmount());
            } else {
                System.out.println("No bids were placed.");
            }
        } else {
            System.out.println("Auction not found or already ended.");
        }
    }
}
