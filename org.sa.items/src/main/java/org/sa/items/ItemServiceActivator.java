package org.sa.items;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.sa.biddingService.BiddingService;

public class ItemServiceActivator implements BundleActivator {
    private ServiceRegistration<ItemService> registration;
    
    public BiddingService biddingService;

    @Override
    public void start(BundleContext context) throws Exception {
        ItemService itemService = new ItemServiceImpl();
        registration = context.registerService(ItemService.class, itemService, null);
        
        ServiceReference<BiddingService> biddingRef = context.getServiceReference(BiddingService.class);
        biddingService = context.getService(biddingRef);

        if (biddingService == null) {
            System.out.println("Item Service not available. Bidding service cannot function.");
            return;
        }
        
        System.out.println("Item service initialized.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (registration != null) {
            registration.unregister();
        }
        System.out.println("Item service stopped.");
    }
}
