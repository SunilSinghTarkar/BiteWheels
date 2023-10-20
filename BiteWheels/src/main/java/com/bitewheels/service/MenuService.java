package com.bitewheels.service;

import com.bitewheels.model.Menus;

public interface MenuService {
	public Menus saveMenu(Integer restaurantId, Menus menu);

	public Menus getByMenuId(Integer menuId);
}
