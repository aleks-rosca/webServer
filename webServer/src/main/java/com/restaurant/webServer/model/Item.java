package com.restaurant.webServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Item {
    @Id
    @GeneratedValue
    private long itemID;
    private String itemName;
    private String itemDesc;
    private double itemPrice;
    private String itemType;

    public Item(){
    }

    public Item(@JsonProperty("itemID") long itemID,
                @JsonProperty("itemName") String itemName,
                @JsonProperty("itemDesc") String itemDesc,
                @JsonProperty("itemPrice") double itemPrice,
                @JsonProperty("itemType") String itemType){
        this.itemID = itemID;
        this.itemDesc = itemDesc;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemType = itemType;

    }

    public long getItemID() {
        return itemID;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemType() {
        return itemType;
    }

    public void setType(String type) {
        this.itemType = itemType;
    }
}