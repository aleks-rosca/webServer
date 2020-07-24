package com.restaurant.webServer.dao;

import com.restaurant.webServer.data.Conn;
import com.restaurant.webServer.model.Order;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository("postgres_order")
public class orderDB implements orderDAO {

    private Conn connection;

    public orderDB() {
        connection = Conn.getInstance();
    }

    @Override
    public String addOrder(Order order) {
        String sql = "INSERT INTO orders(tableNo,totalPrice,date,paied) values('" + order.getTableNo() + "', '" + order.getTotalPrice() + "', CURRENT_TIMESTAMP,'0');";

        try {
            connection.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public Order getOrderbyID(int orderID) {
        String sql = "SELECT * FROM orders WHERE orderid='" + orderID + "';";
        String tabno = null;
        int orderid = 0;
        double totalprice = 0;
        Timestamp date = null;
        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                tabno = rs.getString("tableno");
                orderid = rs.getInt("orderid");
                totalprice = rs.getDouble("totalprice");
                date = rs.getTimestamp("date");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Order order = new Order(tabno, orderid, totalprice, date);
        return order;
    }

    @Override
    public List<Order> getAllNotPaidOrders() {
        String sql = "SELECT * FROM orders Where paid='0';";
        String tabno = null;
        int orderid = 0;
        double totalprice = 0;
        Timestamp date = null;
        ArrayList<Order> orders = new ArrayList<>();
        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                tabno = rs.getString("tableno");
                orderid = rs.getInt("orderid");
                totalprice = rs.getDouble("totalprice");
                date = rs.getTimestamp("date");
                Order order = new Order(tabno, orderid, totalprice, date);
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return orders;
    }

    @Override
    public List<Order> getAllPaidOrders() {
        String sql = "SELECT * FROM orders Where paid='1';";
        String tabno = null;
        int orderid = 0;
        double totalprice = 0;
        Timestamp date = null;
        ArrayList<Order> orders = new ArrayList<>();
        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                tabno = rs.getString("tableno");
                orderid = rs.getInt("orderid");
                totalprice = rs.getDouble("totalprice");
                date = rs.getTimestamp("date");
                Order order = new Order(tabno, orderid, totalprice, date);
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return orders;
    }

    @Override
    public void deleteOrderbyID(int orderID) {
        String sql = "DELETE FROM orders WHERE orderid='" + orderID + "';";
        try {
            connection.delete(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrderToPaid(int orderID) {
        String sql = "UPDATE orders SET paid='1' WHERE orderID="+orderID+";";
        try {
            connection.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders;";
        String tabno = null;
        int orderid = 0;
        double totalprice = 0;
        Timestamp date = null;
        ArrayList<Order> orders = new ArrayList<>();
        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                tabno = rs.getString("tableno");
                orderid = rs.getInt("orderid");
                totalprice = rs.getDouble("totalprice");
                date = rs.getTimestamp("date");
                Order order = new Order(tabno, orderid, totalprice, date);
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return orders;
    }

}

