package org.sa.bidder;

import java.util.ArrayList;
import java.util.List;

public class BidderServiceImpl implements BidderService {
	private final List<Bidder> bidders = new ArrayList<>();
    private long nextId = 1;

	@Override
	public void addBidder(String name) {
		bidders.add(new Bidder(nextId++, name));
	}

	@Override
	public Bidder getBidderById(Long id) {
		return bidders.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public List<Bidder> getAllBidders() {
		return bidders;
	}

}
