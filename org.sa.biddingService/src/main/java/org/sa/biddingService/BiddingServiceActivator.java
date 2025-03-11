package org.sa.biddingService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class BiddingServiceActivator implements BundleActivator {
    private ServiceRegistration<BiddingService> registration;

    public BiddingService biddingService;

    @Override
    public void start(BundleContext context) throws Exception {
        biddingService = new BiddingServiceImpl();
        registration = context.registerService(BiddingService.class, biddingService, null);
        System.out.println("Bidding Service Initialized.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (registration != null) {
            registration.unregister();
        }
        System.out.println("Bidding Service Stopped.");
    }
}
