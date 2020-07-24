package com.restaurant.webServer.dao;

import com.restaurant.webServer.model.Order;

import java.util.List;

public interface orderDAO {

    String addOrder(Order order);

    Order getOrderbyID(int orderID);

    List<Order> getAllNotPaidOrders();

    List<Order> getAllPaidOrders();

    void deleteOrderbyID(int orderID);

    void updateOrderToPaid(int orderID);

    List<Order> getAllOrders();

}
