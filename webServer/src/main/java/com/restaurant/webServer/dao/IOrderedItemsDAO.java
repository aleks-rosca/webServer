package com.restaurant.webServer.dao;

import com.restaurant.webServer.model.OrderItems;

import java.util.List;

public interface IOrderedItemsDAO {

    String addOrderItems(OrderItems orderItem);

    List<OrderItems> getAllOrderItems();

    String deleteOrderItemsbyTableNO(String tableNO);

    List<OrderItems> getOrderItemsbyTableNO(String tableNO);
}
