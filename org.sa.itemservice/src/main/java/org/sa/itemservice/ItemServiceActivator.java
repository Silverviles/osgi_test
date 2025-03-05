package org.sa.itemservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ItemServiceActivator implements BundleActivator {
	
	private ServiceRegistration<ItemService> registration;

	@Override
	public void start(BundleContext context) throws Exception {
		ItemService itemService = new ItemServiceImpl();
		registration = context.registerService(ItemService.class, itemService, null);
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
