package org.sa.biddingService;

import java.util.ArrayList;
import java.util.List;

public class BiddingServiceImpl implements BiddingService {
    private final List<Bid> bids = new ArrayList<>();

    @Override
    public void placeBid(Bid bid) {
        bids.add(bid);
        System.out.println("Bid placed. " + bid);
    }

    @Override
    public Double getHighestBid(Long eventId) {
        return bids.stream()
                .filter(bid -> bid.getEventId().equals(eventId))
                .mapToDouble(Bid::getBidAmount)
                .max()
                .orElse(0.0);
    }

    @Override
    public List<Bid> getAllBids(Long id, char type) {
    	// if type equals to e then get bid by event id
    	// else get bid by item id
    	if (type == 'e') {
    		System.out.println("Retrieving bids using the event id");
    		return bids.stream()
                    .filter(bid -> bid.getEventId().equals(id))
                    .toList();
    	} else {
    		System.out.println("Retrieving the bids using the item id");
    		return bids.stream()
                    .filter(bid -> bid.getItemId().equals(id))
                    .toList();
    	}
    }
}
