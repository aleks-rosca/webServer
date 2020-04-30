package com.restaurant.webServer.service;

import com.restaurant.webServer.dao.orderDAO;
import com.restaurant.webServer.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final orderDAO orderdb;

    @Autowired
    public OrderService(@Qualifier("postgres") orderDAO orderdb) {
        this.orderdb = orderdb;
    }

    public String addOrder(Order order) {
        return orderdb.addOrder(order);
    }
}
