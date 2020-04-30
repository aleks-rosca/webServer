package com.restaurant.webServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    private long orderID;
    private long listID;
    private double totalPrice;
    private int tableNo;


    public Order(@JsonProperty("orderID") long orderID,
                 @JsonProperty("listID") long listID,
                 @JsonProperty("totalPrice") double totalPrice,
                 @JsonProperty("tableNo") int tableNo) {
        this.orderID = orderID;
        this.listID = listID;
        this.totalPrice = totalPrice;
        this.tableNo = tableNo;
    }

    public Order(){

    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getListID() {
        return listID;
    }

    public void setListID(long listID) {
        this.listID = listID;
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
