package com.restaurant.webServer.dao;

import com.restaurant.webServer.model.Log;
import com.restaurant.webServer.model.LogQuantityBought;
import com.restaurant.webServer.model.Income;
import java.util.List;

public interface IlogsDAO {

    List<Log> getAllLog();
    List<LogQuantityBought> getAllLogQuantityBought();
    Income getTotalIncome();
}
