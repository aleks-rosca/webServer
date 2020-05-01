package com.restaurant.webServer.dao;

import com.restaurant.webServer.model.Item;

import java.util.List;

public interface ItemDAO {

    String addItem(Item item);

    List<Item> getAllItems();

    String deleteItem(int id);

    List<Item> getItemByType(String type);
}
