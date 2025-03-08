package org.sa.biddingService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.sa.itemservice.ItemService;

public class BiddingServiceActivator implements BundleActivator {
	private BiddingService biddingService;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Bidding Service Initialized.");

        // Retrieve ItemService reference
        ServiceReference<ItemService> itemServiceRef = context.getServiceReference(ItemService.class);
        ItemService itemService = context.getService(itemServiceRef);

        if (itemService == null) {
            System.out.println("Item Service not available. Bidding service cannot function.");
            return;
        }

        biddingService = new BiddingServiceImpl(itemService);
        context.registerService(BiddingService.class, biddingService, null);

        // Sample Bids (For Testing)
        itemService.AddItem("Laptop", 800.0);
        itemService.AddItem("Phone", 500.0);

        biddingService.placeBid(new Bid("user1", "Laptop", 850.0));
        biddingService.placeBid(new Bid("user2", "Laptop", 900.0));
        biddingService.placeBid(new Bid("user3", "Phone", 600.0));

        System.out.println("Current Highest Bid: " + biddingService.getHighestBid());
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Bidding Service Stopped.");
    }
}
