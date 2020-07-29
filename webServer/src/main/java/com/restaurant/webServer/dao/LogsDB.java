package com.restaurant.webServer.dao;

import com.restaurant.webServer.data.Conn;
import com.restaurant.webServer.model.Income;
import com.restaurant.webServer.model.Log;
import com.restaurant.webServer.model.LogQuantityBought;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository("postgres_log,postgres_logquantitybought")
public class LogsDB implements IlogsDAO {
    private Conn connection;

    public LogsDB() {
        connection = Conn.getInstance();
    }

    @Override
    public List<Log> getAllLog() {
        String sql = "SELECT * FROM log;";
        String tabno_log = null;
        int orderid_log = 0;
        String listOfOrders_log = null;
        double totalprice_log = 0;
        Timestamp date_log = null;
        ArrayList<Log> logs = new ArrayList<>();
        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                tabno_log = rs.getString("tableno_log");
                orderid_log = rs.getInt("orderid_log");
                listOfOrders_log = rs.getString("listoforders_log");
                totalprice_log = rs.getDouble("totalprice_log");
                date_log = rs.getTimestamp("date_log");
                Log log = new Log(tabno_log, orderid_log, listOfOrders_log, totalprice_log, date_log);
                logs.add(log);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return logs;
    }

    @Override
    public List<LogQuantityBought> getAllLogQuantityBought() {
        String sql="SELECT * FROM logOrderItems;";
        int itemID=0;
        String itemName=null;
        int quantitybought=0;
        ArrayList<LogQuantityBought> logs=new ArrayList<>();
        try {
            ResultSet rs=connection.query(sql);
            while (rs.next()){
                itemID=rs.getInt("itemid");
                itemName=rs.getString("itemname");
                quantitybought=rs.getInt("quantitybought");
                LogQuantityBought log=new LogQuantityBought(itemID,itemName,quantitybought);
                logs.add(log);
            }

    } catch (SQLException e) {
        e.printStackTrace();
    }
        return logs;
    }

    @Override
    public Income getTotalIncome() {
        String sql = "SELECT SUM(totalPrice_log) FROM log WHERE (SELECT date_trunc('DAY', date_log))=(SELECT date_trunc('DAY',  CURRENT_TIMESTAMP));";
        double daily=0;
        try {
            ResultSet rs=connection.query(sql);
            while(rs.next())
                daily=rs.getDouble("sum");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql2 = "SELECT SUM(totalPrice_log) FROM log WHERE (SELECT date_trunc('MONTH', date_log))=(SELECT date_trunc('MONTH',  CURRENT_TIMESTAMP));";
        double monthly=0;
        try {
            ResultSet rs=connection.query(sql2);
            while(rs.next())
                monthly=rs.getDouble("sum");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Income income=new Income(daily,monthly);
        return income;
    }

}
