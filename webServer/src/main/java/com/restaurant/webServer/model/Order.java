package com.restaurant.webServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class Order {
    private int tableNo;
    private int orderID;
    private double totalPrice;
    private Timestamp date;


    public Order(@JsonProperty("tableNo") int tableNo,
                 @JsonProperty("orderID") int orderID,
                 @JsonProperty("totalPrice") double totalPrice,
                @JsonProperty("date") Timestamp date) {
        this.tableNo = tableNo;
        this.orderID = orderID;
        this.totalPrice = totalPrice;
        this.date=date;

    }

    public Order() {

    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
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

    public Timestamp getDate() { return date; }

    public void setDate(Timestamp date) { this.date = date; }

    @Override
    public String toString() {
        return "Order{" +
                "tableNo=" + tableNo +
                ", orderID=" + orderID +
                ", totalPrice=" + totalPrice +
                ", date=" + date +
                '}';
    }
}
