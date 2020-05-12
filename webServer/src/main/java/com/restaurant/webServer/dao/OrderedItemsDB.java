package com.restaurant.webServer.dao;

import com.restaurant.webServer.dao.IOrderedItemsDAO;
import com.restaurant.webServer.data.Conn;
import com.restaurant.webServer.model.OrderItems;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("postgres_orderedItems")
public class OrderedItemsDB implements IOrderedItemsDAO {

    private Conn connection;

    public OrderedItemsDB() {
        connection = Conn.getInstance();
    }

    @Override
    public String addOrderItems(OrderItems orderItem) {
        String sql = "INSERT INTO orderedItems(itemID,tableNO,quantity,price) values('" + orderItem.getItemID() + "', '" + orderItem.getTableNo() + "', '" + orderItem.getQuantity() + "',(" + orderItem.getQuantity() + "*(SELECT itemPrice FROM item WHERE itemID=" + orderItem.getItemID() + ")));";

        try {
            connection.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public List<OrderItems> getAllOrderItems() {
        String sql = "SELECT * FROM orderedItems;";
        ArrayList<OrderItems> temp = new ArrayList<>();
        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                int itemID = rs.getInt("itemID");
                String tableNO = rs.getString("tableNO");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                OrderItems i = new OrderItems(itemID, tableNO, quantity, price);
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
        String sql = "SELECT * FROM orderedItems WHERE tableNO='" + tableNO + "';";
        ArrayList<OrderItems> temp = new ArrayList<>();
        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                int itemID = rs.getInt("itemID");
                String tableNo = rs.getString("tableNO");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                OrderItems i = new OrderItems(itemID, tableNo, quantity, price);
                temp.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }
}


