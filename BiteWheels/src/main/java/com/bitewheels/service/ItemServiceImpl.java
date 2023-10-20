package com.bitewheels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitewheels.exception.NotFoundException;
import com.bitewheels.model.Items;
import com.bitewheels.model.Menus;
import com.bitewheels.repository.ItemRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemRepository itemRepo;
	@Autowired
	private MenuService menuService;

	@Override
	public Items saveItem(Integer menuId, Items item) {
		log.info("inside saveItem method " + menuId);
		Menus menu = menuService.getByMenuId(menuId);
		log.info("menu fetched" + menu);
		item.setMenu(menu);
		Items savedItem = itemRepo.save(item);
		return savedItem;
	}

	@Override
	public Items getItemById(Integer itemId) {
		Items item = itemRepo.findById(itemId).orElseThrow(() -> new NotFoundException("Item not found!"));
		return item;
	}

}
