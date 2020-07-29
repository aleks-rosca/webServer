package com.restaurant.webServer.service;

import com.restaurant.webServer.dao.IlogsDAO;
import com.restaurant.webServer.model.Income;
import com.restaurant.webServer.model.Log;
import com.restaurant.webServer.model.LogQuantityBought;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsService {

    private final IlogsDAO logsdb;

    public  LogsService(@Qualifier("postgres_log,postgres_logquantitybought")IlogsDAO logsdb){
        this.logsdb=logsdb;
    }
    public List<Log> getAllLog(){return logsdb.getAllLog();}
    public List<LogQuantityBought> getAllLogQuantityBought(){return  logsdb.getAllLogQuantityBought();}
    public List<Income> getTotalIncom(){return logsdb.getTotalIncome();}
}
