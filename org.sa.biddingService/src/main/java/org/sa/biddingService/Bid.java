package org.sa.biddingService;

import java.util.UUID;

public class Bid {
    private final String id;
    private Long itemId;
    private Long eventId;
    private String name;
    private double bidAmount;

    public Bid(Long itemId, Long eventId, String name, double bidAmount) {
        this.id = UUID.randomUUID().toString();
        this.itemId = itemId;
        this.eventId = eventId;
        this.name = name;
        this.bidAmount = bidAmount;
    }

    public String getId() {
        return id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", bidAmount=" + bidAmount +
                '}';
    }
}
