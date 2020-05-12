package com.restaurant.webServer.api;

import com.restaurant.webServer.model.Item;
import com.restaurant.webServer.model.Order;
import com.restaurant.webServer.model.OrderItems;
import com.restaurant.webServer.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/ordereditems")
@RestController
public class OrderItemsController {
    private final OrderItemsService orderItemsService;

    @Autowired
    public OrderItemsController(OrderItemsService orderItemsService) {
        this.orderItemsService = orderItemsService;
    }

    @PostMapping
    public void addOrderItem(@RequestBody OrderItems orderItems) {
        orderItemsService.addOrderItems(orderItems);
    }

    @GetMapping
    public List<OrderItems> getAllOrderItems() {
        return orderItemsService.getAllOrderItems();
    }

    @GetMapping(path = "{tableNO}")
    public List<OrderItems> getAllOrderItemsbyTableNO(@PathVariable("tableNO") String tableNO) {
        return orderItemsService.getOrderItemsbyTableNO(tableNO);
    }

    @DeleteMapping(path = "{tableNO}")
    public void deleteOrderItemsbyTableNO(@PathVariable("tableNO") String tableNO) {
        orderItemsService.deleteOrderItemsbyTableNO(tableNO);
    }
}
