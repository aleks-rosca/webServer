package com.restaurant.webServer.dao;

import com.restaurant.webServer.data.Conn;
import com.restaurant.webServer.model.Order;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository("postgres")
public class orderDB implements orderDAO {

    private Conn connection;

    public orderDB() {
        connection = Conn.getInstance();
    }

    @Override
    public String addOrder(Order order) {
        String sql = "INSERT INTO item values('" + order.getOrderID() + "', '" + order.getListID() + "', '" + order.getTotalPrice() + "', '" + order.getTableNo() + "', CURRENT_DATE);";

        try {
            connection.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}

