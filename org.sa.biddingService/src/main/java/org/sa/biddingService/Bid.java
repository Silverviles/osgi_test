package org.sa.biddingService;

import java.util.UUID;

public class Bid {
	private String id;
	private String bidderId;
	private String name;
	private double bidAmount;

	// Constructor auto-generates an ID
	public Bid(String bidderId, String name, double bidAmount) {
		this.id = UUID.randomUUID().toString();
		this.bidderId = bidderId;
		this.name = name;
		this.bidAmount = bidAmount;
	}

	// Getter for ID
	public String getId() {
		return id;
	}

	public String getBidderId() {
		return bidderId;
	}

	public String getName() {
		return name;
	}

	public double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	@Override
	public String toString() {
		return "Bid{" +
			   "id='" + id + '\'' +
			   ", bidderId='" + bidderId + '\'' +
			   ", name='" + name + '\'' +
			   ", bidAmount=" + bidAmount +
			   '}';
	}

}
