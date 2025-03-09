package org.sa.notificationservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class NotificationActivator implements BundleActivator {

	private ServiceRegistration<NotificationService> serviceRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Notification Service Activated");
		NotificationService notificationService = new NotificationServiceImpl();
		context.registerService(NotificationService.class, notificationService, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Notification Service Deactivated");
		if (serviceRegistration != null) {
			serviceRegistration.unregister();
		}
	}
	
}
