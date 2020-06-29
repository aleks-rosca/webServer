package com.restaurant.webServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItems {

    private long itemID;
    private String itemName;
    private String tableNO;
    private int quantity;
    private double price;

    public OrderItems(   @JsonProperty("itemID") long itemID,
                         @JsonProperty("tableNO") String tableNO,
                         @JsonProperty("quantity") int quantity,
                         @JsonProperty("price") double price
    ) {
        this.itemID=itemID;
        this.tableNO=tableNO;
        this.quantity=quantity;
        this.price = price;

    }
    public OrderItems(   @JsonProperty("itemID") long itemID,
                         @JsonProperty("itemName") String itemName,
                         @JsonProperty("tableNO") String tableNO,
                         @JsonProperty("quantity") int quantity,
                         @JsonProperty("price") double price
    ) {
        this.itemID=itemID;
        this.itemName=itemName;
        this.tableNO=tableNO;
        this.quantity=quantity;
        this.price = price;

    }
    public OrderItems(){

    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public String getTableNo() {
        return tableNO;
    }

    public void setTableNo(String tableNO) {
        this.tableNO = tableNO;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "itemID=" + itemID +
                ", tableNO=" + tableNO +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
