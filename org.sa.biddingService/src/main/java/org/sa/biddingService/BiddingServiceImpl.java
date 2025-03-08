package org.sa.biddingService;

import java.util.concurrent.atomic.AtomicReference;

import org.sa.itemservice.ItemService;

public class BiddingServiceImpl implements BiddingService {
	
	private final AtomicReference<Bid> highestBid = new AtomicReference<>();
    private final ItemService itemService;

    public BiddingServiceImpl(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public void placeBid(Bid bid) {
        if (itemService.getItemByName(bid.getName()) == null) {
            System.out.println("Invalid item: " + bid.getName());
            return;
        }

        // Ensure the bid is higher
        Bid currentHighest = highestBid.get();
        if (currentHighest == null || bid.getBidAmount() > currentHighest.getBidAmount()) {
            highestBid.set(bid);
            System.out.println("New highest bid: " + bid);
        } else {
            System.out.println("Bid too low: " + bid);
        }
    }

    @Override
    public Bid getHighestBid() {
        return highestBid.get();
    }

}
