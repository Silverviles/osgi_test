package org.sa.manager;

public class ManagerServiceImpl implements ManagerService {
    private Double minimumBid = 0.0;

    @Override
    public void setMinimumBid(Double minimumBid) {
        this.minimumBid = minimumBid;
    }

    @Override
    public Double getMinimumBid() {
        return minimumBid;
    }
}
