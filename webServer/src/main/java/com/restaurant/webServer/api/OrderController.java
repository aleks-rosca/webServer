package com.restaurant.webServer.api;

import com.restaurant.webServer.model.Order;
import com.restaurant.webServer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(path = "/byID/{orderID}")
    public Order getOrderbyID(@PathVariable("orderID") int orderID){
       return orderService.getOrderbyID(orderID);
    }
    @DeleteMapping(path="{orderID}")
    public void deleteOrderbyID(@PathVariable("orderID")int orderID){
        orderService.deleteOrderbyID(orderID);
    }
    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping(path="NotPaidOrders")
    public List<Order> getAllNotPaieOrders(){ return orderService.getAllNotPaidOrders(); }
    @GetMapping(path="PaidOrders")
    public List<Order> getAllPaieOrders(){ return orderService.getAllPaidOrders(); }
    @PostMapping(path="PaidOrders/{orderID}")
    public void updateOrderToPaid(@PathVariable("orderID")int orderID){
        orderService.updateOrderToPaid(orderID);
    }
}
