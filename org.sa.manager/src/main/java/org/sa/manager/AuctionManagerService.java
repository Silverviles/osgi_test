package org.sa.manager;




public interface AuctionManagerService {
    

    void createAuction(AuctionItem item);
    void placeBid(String itemId, Bid bid);
    Auction getAuction(String itemId);
    void endAuction(String itemId);
}