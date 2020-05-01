package com.restaurant.webServer.dao;

import com.restaurant.webServer.model.Order;

import java.util.List;

public interface orderDAO {
    String addOrder(Order order);
    Order getOrderbyID(int orderID);
    void deleteOrderbyID(int orderID);
    List<Order> getAllOrders();
}
