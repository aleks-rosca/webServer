package com.restaurant.webServer.dao;

import com.restaurant.webServer.model.Item;
import com.restaurant.webServer.data.Conn;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("postgres_item")
public class itemDB implements ItemDAO {

    private Conn connection;

    public itemDB() {
        connection = Conn.getInstance();
    }

    @Override
    public String addItem(Item newItem) {
        String sql = "INSERT INTO item(itemName,itemDesc,itemPrice,itemType) values('" + newItem.getItemName() + "', '" + newItem.getItemDesc() + "', '" + newItem.getItemPrice() + "', '" + newItem.getItemType() + "');";

        try {
            connection.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM item;";
        ArrayList<Item> temp = new ArrayList<>();
        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                int itemID = rs.getInt("itemID");
                String itemName = rs.getString("itemName");
                String itemDesc = rs.getString("itemDesc");
                int itemPrice = rs.getInt("itemPrice");
                String itemType = rs.getString("itemType");
                Item i = new Item(itemID,itemName, itemDesc, itemPrice, itemType);
                temp.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }



    @Override
    public String deleteItem(String name) {
        String sql = "DELETE FROM item WHERE itemName = '" + name + "';";
        try {
            connection.delete(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}


