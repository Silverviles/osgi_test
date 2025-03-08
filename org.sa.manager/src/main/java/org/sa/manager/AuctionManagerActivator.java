package org.sa.manager;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class AuctionManagerActivator implements BundleActivator {

    private ServiceRegistration<AuctionManagerService> serviceRegistration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Starting AuctionManagerService...");

        AuctionManagerService auctionManagerService = new AuctionManagerServiceImpl();

        serviceRegistration = bundleContext.registerService(
            AuctionManagerService.class,
            auctionManagerService,
            null
        );

        System.out.println("AuctionManagerService registered successfully.");
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
