package org.sa.bidder;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.sa.itemservice.Item;
import org.sa.itemservice.ItemService;

public class BidderActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Bidder service initialized.");
		
		ServiceReference<ItemService> reference = context.getServiceReference(ItemService.class);
		
		if (reference != null) {
			ItemService itemService = context.getService(reference);

            itemService.AddItem("sayun", 50D);
            itemService.AddItem("chatgpt", 20D);
            List<Item> items = itemService.listAllItems();
            
            for (Item item : items) {
            	System.out.println("Item: " + item.getName() + ", Value: " + item.getPrice());
            }
        } else {
            System.out.println("Item service not available.");
        }
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Bidder service stopped.");
	}

}
