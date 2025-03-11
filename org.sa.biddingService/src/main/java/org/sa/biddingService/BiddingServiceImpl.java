package org.sa.biddingService;

import java.util.ArrayList;
import java.util.List;

public class BiddingServiceImpl implements BiddingService {
    private final List<Bid> bids = new ArrayList<>();

    @Override
    public void placeBid(Bid bid) {
        bids.add(bid);
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
    	if (type == 'e') {
    		return bids.stream()
                    .filter(bid -> bid.getEventId().equals(id))
                    .toList();
    	} else {
    		return bids.stream()
                    .filter(bid -> bid.getItemId().equals(id))
                    .toList();
    	}
    }
}
