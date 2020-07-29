package com.restaurant.webServer.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class Log {

    private String tableNO_log;
    private int orderID_log;
    private String listOfOrders_log;
    private double totalPrice_log;
    private Timestamp date_log;

    public Log(@JsonProperty("tableNO_log")String tableNO_log,
               @JsonProperty("orderID_log")int orderID_log,
               @JsonProperty("listOfOrders_log") String listOfOrders_log,
               @JsonProperty("totalPrice_log") double totalPrice_log,
               @JsonProperty("date_log") Timestamp date_log
    )
    {
        this.tableNO_log=tableNO_log;
        this.orderID_log=orderID_log;
        this.listOfOrders_log=listOfOrders_log;
        this.totalPrice_log=totalPrice_log;
        this.date_log=date_log;
    }

    public String getTableNO_log() {
        return tableNO_log;
    }

    public void setTableNO_log(String tableNO_log) {
        this.tableNO_log = tableNO_log;
    }

    public int getOrderID_log() {
        return orderID_log;
    }

    public void setOrderID_log(int orderID_log) {
        this.orderID_log = orderID_log;
    }

    public String getListOfOrders_log() {
        return listOfOrders_log;
    }

    public void setListOfOrders_log(String listOfOrders_log) {
        this.listOfOrders_log = listOfOrders_log;
    }

    public double getTotalPrice_log() {
        return totalPrice_log;
    }

    public void setTotalPrice_log(int totalPrice_log) {
        this.totalPrice_log = totalPrice_log;
    }

    public Timestamp getDate_log() {
        return date_log;
    }

    public void setDate_log(Timestamp date_log) {
        this.date_log = date_log;
    }

    @Override
    public String toString() {
        return "Log{" +
                "tableNO_log='" + tableNO_log + '\'' +
                ", orderID_log=" + orderID_log +
                ", listOfOrders_log='" + listOfOrders_log + '\'' +
                ", totalPrice_log=" + totalPrice_log +
                ", date_log=" + date_log +
                '}';
    }
}
