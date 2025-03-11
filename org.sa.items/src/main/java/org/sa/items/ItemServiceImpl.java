package org.sa.items;

import java.util.ArrayList;
import java.util.List;
import org.osgi.service.component.annotations.Reference;
import org.sa.biddingService.BiddingService;

public class ItemServiceImpl implements ItemService {
    private final List<Item> items = new ArrayList<>();
    private long nextId = 1;

    private BiddingService biddingService;

    public ItemServiceImpl(BiddingService service) {
		this.biddingService = service;
	}
    
    @Override
    public List<Item> getAllItems() {
        return items;
    }

    @Override
    public Item getItemById(Long Id) {
        return items.stream().filter(item -> item.getId().equals(Id))
                .findFirst().orElse(null);
    }

    @Override
    public void removeItemById(Long Id) {
    	if (biddingService.getAllBids(Id, 'a').isEmpty()) {
    		items.stream().filter(item -> item.getId().equals(Id))
            .findFirst()
            .ifPresent(items::remove);
    	} else {
    		System.out.println("Item is currently bidding.");
    	}
    }

    @Override
    public void AddItem(String name) {
        items.add(new Item(nextId++, name));
    }
}
