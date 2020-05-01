package com.restaurant.webServer.service;

import com.restaurant.webServer.dao.ItemDAO;
import com.restaurant.webServer.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemDAO itemdb;

    @Autowired
    public ItemService(@Qualifier("postgres_item") ItemDAO itemdb) {
        this.itemdb = itemdb;
    }

    public String addItem(Item item) {
        return itemdb.addItem(item);

    }
    public List<Item> getAllItems(){
        return itemdb.getAllItems();
    }

    public String deleteItem(int id){
        return itemdb.deleteItem(id);
    }

    public Item getItemById(int id){
        return itemdb.getItemById(id);
    }

    public List<Item> getItemByType(String type){
        return itemdb.getItemByType(type);
    }
}
