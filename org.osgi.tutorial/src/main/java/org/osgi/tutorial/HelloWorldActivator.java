package org.osgi.tutorial;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.silverviles.platform.Platform;

public class HelloWorldActivator implements BundleActivator{

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Hello World!");
		
		ServiceReference<Platform> reference = context.getServiceReference(Platform.class);
		
		if (reference != null) {
            Platform platform = context.getService(reference);

            // Call the platformHealth() method
            if (platform != null) {
                platform.platformHealth();
                System.out.println("Platform health check invoked.");
            } else {
                System.out.println("Failed to get Platform service.");
            }
        } else {
            System.out.println("Platform service not available.");
        }
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye World!");
	}

}
