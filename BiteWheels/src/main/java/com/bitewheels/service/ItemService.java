package com.bitewheels.service;

import com.bitewheels.model.Items;

public interface ItemService {

	public Items saveItem(Integer menuId, Items item);

	public Items getItemById(Integer itemId);

}
