package com.restaurant.webServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogQuantityBought {

    private int itemID;
    private String itemName;
    private int quantitybought;

    public LogQuantityBought(
            @JsonProperty("itemID") int itemID,
            @JsonProperty("itemName") String itemName,
            @JsonProperty("quantitybought") int quantitybought
    )
    {
        this.itemID=itemID;
        this.itemName=itemName;
        this.quantitybought=quantitybought;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantitybought() {
        return quantitybought;
    }

    public void setQuantitybought(int quantitybought) {
        this.quantitybought = quantitybought;
    }

    @Override
    public String toString() {
        return "LogQuantityBought{" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", quantitybought=" + quantitybought +
                '}';
    }
}
