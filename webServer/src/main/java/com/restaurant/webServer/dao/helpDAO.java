package com.restaurant.webServer.dao;

import com.restaurant.webServer.model.Help;

import java.util.List;

public interface helpDAO {
    void needHelp(String tableNo);
    void helped(String tableNo);
    List<Help> AllTablesThatNeedHelp();

}