package org.silverviles.platform;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class PlatformActivator implements BundleActivator {

	private ServiceRegistration<?> registration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		Platform platform = new PlatformImpl();
		registration = context.registerService(Platform.class.getName(), platform, null);
		System.out.println("Platform service initialized.");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		if (registration != null) {
			registration.unregister();
		}
		System.out.println("Platform service stopped.");
	}

}
