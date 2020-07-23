package com.restaurant.webServer.service;

import com.restaurant.webServer.dao.IOrderedItemsDAO;
import com.restaurant.webServer.model.OrderItems;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemsService {

    private final IOrderedItemsDAO orderedItemsdb;

    public OrderItemsService(@Qualifier("postgres_orderedItems") IOrderedItemsDAO orderItemdb) {
       this.orderedItemsdb = orderItemdb;
    }

    public String addOrderItems(List<OrderItems> orderItems){
        StringBuilder response = new StringBuilder();
        for(int i = 0; i < orderItems.size(); i++){
            response.append(orderedItemsdb.addOrderItems(orderItems.get(i)));
        }
        return response.toString();
    };

    public List<OrderItems> getAllOrderItems(){
        return orderedItemsdb.getAllOrderItems();
    };

    public List<OrderItems> getAllKitchenOrderItems(){ return orderedItemsdb.getAllKitchenOrderItems(); }

    public List<OrderItems> getAllWaiterOrderItems(){
        return orderedItemsdb.getAllWaiterOrderItems();
    };

    public String deleteOrderItemsbyTableNO(String tableNO){
        return orderedItemsdb.deleteOrderItemsbyTableNO(tableNO);
    };

    public List<OrderItems> getOrderItemsbyTableNO(String tableNO){
        return orderedItemsdb.getOrderItemsbyTableNO(tableNO);
    };
}
