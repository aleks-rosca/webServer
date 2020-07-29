package com.restaurant.webServer.dao;

import com.restaurant.webServer.data.Conn;
import com.restaurant.webServer.model.Help;
import com.restaurant.webServer.model.Order;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository("postgres_help")
public class helpDB implements helpDAO{

    private Conn connection;
    public helpDB(){
        connection = Conn.getInstance();
    }
    @Override
    public void needHelp(String tableNo) {
        String sql = " update help set needHelp = '1' where tableNo='"+ tableNo +"';";

        try {
            connection.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void helped(String tableNo) {
        String sql = " update help set needHelp = '0' where tableNo='"+ tableNo +"';";
        try {
            connection.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Help> AllTablesThatNeedHelp() {
        String sql = "Select * from help where needHelp='1';";

        ArrayList <Help> temp = new ArrayList<>();

        try {
            ResultSet rs = connection.query(sql);
            while (rs.next()) {
                String  tableNo = rs.getString("tableNo");
                boolean needHelp = rs.getBoolean("needHelp");

                Help help = new Help(tableNo,needHelp);
                temp.add(help);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return temp;

    }
}