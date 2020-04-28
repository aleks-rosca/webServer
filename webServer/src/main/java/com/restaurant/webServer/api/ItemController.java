package com.restaurant.webServer.api;

import com.restaurant.webServer.model.Item;
import com.restaurant.webServer.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/item")
@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }
    @GetMapping
    public List<Item> getAllItems(){
        return  itemService.getAllItems();
    }
}
