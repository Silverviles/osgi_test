package org.sa.itemservice;

import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService{
	private volatile List<Item> items = new ArrayList<>();

	@Override
	public List<Item> listAllItems() {
		return items;
	}

	@Override
	public Item getItemByName(String name) {
		return items.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
	}

	@Override
	public void removeItemByName(String name) {
		Item item = items.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
		if (item != null) {
			items.remove(item);
		}
	}

	@Override
	public void AddItem(String name, Double price) {
		Item item = new Item(0L, name, price);
		items.add(item);
	}
	

}
