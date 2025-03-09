package org.sa.manager;

import java.util.ArrayList;
import java.util.List;
import org.sa.itemservice.Item; // Import the Item class
public class Auction {
    private Item auctionItem;  // Use Item instead of AuctionItem
    private boolean isActive;

    public Auction(Item auctionItem) {  // Constructor now takes Item
        this.auctionItem = auctionItem;
        this.isActive = true;
    }

    public Item getAuctionItem() {  // Return Item instead of AuctionItem
        return auctionItem;
    }

  

    public boolean isActive() {
        return isActive;
    }

   

    public void endAuction() {
        this.isActive = false;
    }


 
}
