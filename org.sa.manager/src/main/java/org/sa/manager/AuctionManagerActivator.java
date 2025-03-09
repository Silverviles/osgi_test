package org.sa.manager;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.sa.itemservice.Item;
import org.sa.itemservice.ItemService;
import org.sa.itemservice.ItemServiceImpl;


public class AuctionManagerActivator implements BundleActivator {

    private ServiceRegistration<AuctionManagerService> serviceRegistration;
    private ItemService itemService;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Starting AuctionManagerService...");

        AuctionManagerService auctionManagerService = new AuctionManagerServiceImpl();

        itemService = new ItemServiceImpl();

        serviceRegistration = bundleContext.registerService(
            AuctionManagerService.class,
            auctionManagerService,
            null
        );

        bundleContext.registerService(AuctionManagerItemCommand.class, new AuctionManagerItemCommand(), null);

    

        System.out.println("AuctionManagerService registered and ready for user interaction.");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stopping AuctionManagerService...");

        if (serviceRegistration != null) {
            serviceRegistration.unregister();
            serviceRegistration = null;
        }

        System.out.println("AuctionManagerService unregistered.");
    }
}
