package com.restaurant.webServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    private int tableNo;
    private long orderID;
    private double totalPrice;


    public Order(@JsonProperty("tableNo") int tableNo,
                 @JsonProperty("orderID") long orderID,
                 @JsonProperty("totalPrice") double totalPrice) {
        this.tableNo = tableNo;
        this.orderID = orderID;
        this.totalPrice = totalPrice;

    }

    public Order() {

    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
