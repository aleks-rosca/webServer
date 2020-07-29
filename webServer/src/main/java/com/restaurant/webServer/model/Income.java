package com.restaurant.webServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Income {

    private double daily;
    private double monthly;
    public Income(@JsonProperty("daily") double daily,
                  @JsonProperty("monthly")double monthly){
        this.daily=daily;
        this.monthly=monthly;
    }

    public double getDaily() {
        return daily;
    }

    public void setDaily(double daily) {
        this.daily = daily;
    }

    public double getMonthly() {
        return monthly;
    }

    public void setMonthly(double monthly) {
        this.monthly = monthly;
    }

    @Override
    public String toString() {
        return "Income{" +
                "daily=" + daily +
                ", monthly=" + monthly +
                '}';
    }
}
