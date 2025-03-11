package org.sa.event;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.sa.biddingService.BiddingService;


public class EventServiceActivator implements BundleActivator {
    private ServiceRegistration<EventService> registration;
    
    public BiddingService biddingService;

    @Override
    public void start(BundleContext context) throws Exception {
    	ServiceReference<BiddingService> biddingRef = context.getServiceReference(BiddingService.class);
        biddingService = context.getService(biddingRef);

        if (biddingService == null) {
            System.out.println("Item Service not available. Bidding service cannot function.");
            return;
        }
    	
        EventService eventService = new EventServiceImpl(biddingService);
        registration = context.registerService(EventService.class, eventService, null);
        System.out.println("Event service initialized.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (registration != null) {
            registration.unregister();
        }
        System.out.println("Event service stopped.");
    }
}
