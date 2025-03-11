package org.sa.items;

import java.util.List;

public interface ItemService {
	List<Item> getAllItems();
	Item getItemById(Long Id);
	void removeItemById(Long Id);
	void AddItem(String name);
}
