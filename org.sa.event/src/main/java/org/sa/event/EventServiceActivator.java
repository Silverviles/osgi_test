package org.sa.event;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class EventServiceActivator implements BundleActivator {
    private ServiceRegistration<EventService> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        EventService eventService = new EventServiceImpl();
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
