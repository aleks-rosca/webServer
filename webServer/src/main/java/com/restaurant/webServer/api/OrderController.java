package com.restaurant.webServer.api;

import com.restaurant.webServer.model.Order;
import com.restaurant.webServer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/order")
@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public void addOrder(@RequestBody Order order){
        orderService.addOrder(order);

    }
}
