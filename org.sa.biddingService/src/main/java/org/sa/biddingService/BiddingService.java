

package org.sa.biddingService;

import java.util.List;

public interface BiddingService {
	void placeBid(Bid bid);
    Double getHighestBid(Long eventId);
    List<Bid> getAllBids(Long id, char type);
}
