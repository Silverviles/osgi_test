package org.sa.manager;

import org.sa.itemservice.Item;

public interface AuctionManagerService {
    
    void createAuction(Item item);
    Auction getAuction(String itemId);
    void endAuction(String itemId);
    
}