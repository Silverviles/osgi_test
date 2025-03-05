package org.sa.itemservice;

import java.util.List;

public interface ItemService {
	List<Item> listAllItems();
	Item getItemByName(String name);
	void removeItemByName(String name);
	void AddItem(String name, Double price);
}
