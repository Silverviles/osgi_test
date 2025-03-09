package org.sa.event;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class EventActivator implements BundleActivator {
    
    private ServiceRegistration<EventService> eventServiceRegistration;


    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Event service initialized.");
        
        

        // Register the EventService
        EventService eventService = new EventServiceImpl();
        eventServiceRegistration = context.registerService(EventService.class, eventService, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Event service stopped.");
        if (eventServiceRegistration != null) {
            eventServiceRegistration.unregister();
        }
    }
}
