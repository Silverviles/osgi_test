package org.sa.manager;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ManagerServiceActivator implements BundleActivator {
    private ServiceRegistration<ManagerService> registration;

    public ManagerService managerService;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        managerService = new ManagerServiceImpl();
        registration = bundleContext.registerService(ManagerService.class, managerService, null);
        System.out.println("Manager Service Started");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        if (registration != null) {
            registration.unregister();
        }
        System.out.println("Manager Service Stopped.");
    }
}
