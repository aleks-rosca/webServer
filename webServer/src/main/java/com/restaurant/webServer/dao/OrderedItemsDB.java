package com.restaurant.webServer.dao;

import com.restaurant.webServer.data.Conn;
import com.restaurant.webServer.model.OrderItems;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("postgres_orderedItems")
public class OrderedItemsDB implements IOrderedItemsDAO{

    private Conn connection;

    public OrderedItemsDB() {
        connection = Conn.getInstance();
    }

    @Override
    public String addOrderItems(OrderItems orderItem) {
        String sql = "INSERT INTO orderedItems(itemID,tableNO,quantity,price,ready) values('" + orderItem.getItemID() + "', '" + orderItem.getTableNo() + "', '" + orderItem.getQuantity() +"',("+orderItem.getQuantity()+"*(SELECT itemPrice FROM item WHERE itemID="+orderItem.getItemID()+")),'0');";

        try {
            connection.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public List<OrderItems> getAllOrderItems() {
        String sql = "SELECT * FROM orderedItems natural join item;";
        ArrayList<OrderItems> temp = new ArrayList<>();
        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                int itemID = rs.getInt("itemID");
                String itemName=rs.getString("itemName");
                String tableNO = rs.getString("tableNO");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                OrderItems i = new OrderItems(itemID,itemName,tableNO, quantity, price);
                temp.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public List<OrderItems> getAllKitchenOrderItems() {
        String sql = "SELECT * FROM orderedItems natural join item where ready='0';";
        ArrayList<OrderItems> temp = new ArrayList<>();
        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                int itemID = rs.getInt("itemID");
                String itemName=rs.getString("itemName");
                String tableNO = rs.getString("tableNO");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                OrderItems i = new OrderItems(itemID,itemName,tableNO, quantity, price);
                temp.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public List<OrderItems> getAllWaiterOrderItems() {
        String sql = "SELECT * FROM orderedItems natural join item where ready='1';";
        ArrayList<OrderItems> temp = new ArrayList<>();
        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                int itemID = rs.getInt("itemID");
                String itemName=rs.getString("itemName");
                String tableNO = rs.getString("tableNO");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                OrderItems i = new OrderItems(itemID,itemName,tableNO, quantity, price);
                temp.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public String deleteOrderItemsbyTableNO(String tableNO) {
        String sql = "DELETE FROM orderedItems WHERE tableNO = '" + tableNO + "';";
        try {
            connection.delete(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public List<OrderItems> getOrderItemsbyTableNO(String tableNO) {
        String sql = "SELECT * FROM orderedItems WHERE tableNO='"+tableNO+"';";
        ArrayList<OrderItems> temp = new ArrayList<>();
        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                int itemID = rs.getInt("itemID");
                String tableNo = rs.getString("tableNO");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                OrderItems i = new OrderItems(itemID,"itemName",tableNo, quantity, price);
                temp.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
