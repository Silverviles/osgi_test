package org.sa.event;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.sa.notificationservice.NotificationService;

public class EventActivator implements BundleActivator {
    
    private ServiceRegistration<EventService> eventServiceRegistration;
    @Override
    public void start(BundleContext context) throws Exception {
        System.out.println("Event service initialized.");

        // Register the EventService
        EventService eventService = new EventServiceImpl();
        eventServiceRegistration = context.registerService(EventService.class, eventService, null);

        // Retrieve NotificationService (if available)
        ServiceReference<NotificationService> reference = context.getServiceReference(NotificationService.class);
        if (reference != null) {
            context.getService(reference);
            System.out.println("Notification service found.");
        } else {
            System.out.println("Notification service not available.");
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("Event service stopped.");
        if (eventServiceRegistration != null) {
            eventServiceRegistration.unregister();
        }
    }
}
