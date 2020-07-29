package com.restaurant.webServer.service;

import com.restaurant.webServer.dao.orderDAO;
import com.restaurant.webServer.model.Item;
import com.restaurant.webServer.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final orderDAO orderdb;

    @Autowired
    public OrderService(@Qualifier("postgres_order") orderDAO orderdb) {
        this.orderdb = orderdb;
    }

    public String addOrder(Order order) {
        return orderdb.addOrder(order);
    }

    public Order getOrderbyID(int orderID){
        return orderdb.getOrderbyID(orderID);
    }

    public void deleteOrderbyID(int orderID){orderdb.deleteOrderbyID(orderID);}

    public List<Order> getAllOrders(){return orderdb.getAllOrders();}

}
