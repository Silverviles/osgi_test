package org.sa.bidder;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.sa.itemservice.Item;
import org.sa.itemservice.ItemService;

public class BidderActivator implements BundleActivator {
	
	private ServiceRegistration<BidderService> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Bidder service initialized.");

        // Register BidderService
        BidderService bidderService = new BidderServiceImpl();
        registration = context.registerService(BidderService.class, bidderService, null);

        // Consume ItemService
        ServiceReference<ItemService> reference = context.getServiceReference(ItemService.class);

        if (reference != null) {
            ItemService itemService = context.getService(reference);

            itemService.AddItem("Laptop", 500D);
            itemService.AddItem("Smartphone", 300D);

            bidderService.addBidder("Alice");
            bidderService.addBidder("Bob");

            System.out.println("Item and Bidder services ready.");
        } else {
            System.out.println("Item service not available.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (registration != null) {
            registration.unregister();
        }
        System.out.println("Bidder service stopped.");
    }

}
