package org.sa.manager;
import java.util.HashMap;
import java.util.Map;

import org.sa.itemservice.Item; // Import the Item class

public class AuctionManagerServiceImpl implements AuctionManagerService {

    // A simple in-memory store mapping itemId -> Auction
    private final Map<String, Auction> auctions = new HashMap<>();

    @Override
    public void createAuction(Item item) {  // Changed AuctionItem to Item
        if (item == null || auctions.containsKey(item.getId())) {
            System.out.println("Auction already exists or item is invalid.");
            return;
        }
        Auction newAuction = new Auction(item);  // Create Auction with Item
        auctions.put(item.getId().toString(), newAuction);  // Assuming itemId is the unique identifier for Item
        System.out.println("Auction created for item: " + item.getName()+" with id :"+item.getId());
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
            System.out.println("Auction ended for item: " + auction.getAuctionItem().getName());
        
        } else {
            System.out.println("Auction not found or already ended.");
        }
    }
}
