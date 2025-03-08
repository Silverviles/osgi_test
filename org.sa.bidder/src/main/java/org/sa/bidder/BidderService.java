package org.sa.bidder;

import java.util.List;

public interface BidderService {
	void addBidder(String name);
    Bidder getBidderById(Long id);
    List<Bidder> getAllBidders();

}
