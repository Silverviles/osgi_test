package org.sa.biddingService;

public interface BiddingService {
	void placeBid(Bid bidder);
    Bid getHighestBid();
}
