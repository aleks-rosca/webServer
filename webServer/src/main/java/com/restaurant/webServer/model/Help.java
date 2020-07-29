package com.restaurant.webServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Help {

    private String tableNo;
    private boolean needHelp;

    public Help(@JsonProperty("tableNo")  String tableNo, @JsonProperty boolean needHelp){

        this.tableNo = tableNo;
        this.needHelp = needHelp;
    }
    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public boolean isNeedHelp() {
        return needHelp;
    }

    public void setNeedHelp(boolean needHelp) {
        this.needHelp = needHelp;
    }


}