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

    public String addOrderItems(OrderItems orderItem){
        return orderedItemsdb.addOrderItems(orderItem);
    };

    public List<OrderItems> getAllOrderItems(){
        return orderedItemsdb.getAllOrderItems();
    };

    public String deleteOrderItemsbyTableNO(String tableNO){
        return orderedItemsdb.deleteOrderItemsbyTableNO(tableNO);
    };

    public List<OrderItems> getOrderItemsbyTableNO(String tableNO){
        return orderedItemsdb.getOrderItemsbyTableNO(tableNO);
    };
}
