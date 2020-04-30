package com.restaurant.webServer.dao;

import com.restaurant.webServer.data.Conn;
import com.restaurant.webServer.model.Order;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository("postgres_order")
public class orderDB implements orderDAO {

    private Conn connection;

    public orderDB() {
        connection = Conn.getInstance();
    }

    @Override
    public String addOrder(Order order) {
        String sql = "INSERT INTO orders values('" + order.getTableNo() + "', '" + order.getOrderID() + "', '" + order.getTotalPrice() + "', CURRENT_TIMESTAMP);";

        try {
            connection.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}

