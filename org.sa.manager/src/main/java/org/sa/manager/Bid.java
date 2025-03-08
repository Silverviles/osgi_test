package org.sa.manager;

public class Bid {
    private String bidderId;
    private double amount;

    public Bid() {}

    public Bid(String bidderId, double amount) {
        this.bidderId = bidderId;
        this.amount = amount;
    }

    public String getBidderId() {
        return bidderId;
    }
    public void setBidderId(String bidderId) {
        this.bidderId = bidderId;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
