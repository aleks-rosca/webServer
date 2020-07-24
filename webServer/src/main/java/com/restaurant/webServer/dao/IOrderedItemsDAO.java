package com.restaurant.webServer.dao;

import com.restaurant.webServer.model.OrderItems;

import java.util.List;

public interface IOrderedItemsDAO {

    String addOrderItems(OrderItems orderItem);

    List<OrderItems> getAllOrderItems();

    List<OrderItems> getAllKitchenOrderItems();

    List<OrderItems> getAllWaiterOrderItems();

    String deleteOrderItemsbyTableNO(String tableNO);

    String updateOrderedItemsbyTNoIid(int itemID,String tableNo);

    void deliveredItems(int itemId, String tableNo);

    List<OrderItems> getOrderItemsbyTableNO(String tableNO);
}
