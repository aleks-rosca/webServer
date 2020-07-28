package com.restaurant.webServer.service;


import com.restaurant.webServer.dao.helpDAO;
import com.restaurant.webServer.model.Help;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpService {

    private final helpDAO HELP_DB;
    @Autowired
    public HelpService(@Qualifier("postgres_help") helpDAO HELP_DB) {
        this.HELP_DB= HELP_DB;
    }

    public List<Help> AllTablesThatNeedHelp(){

        return HELP_DB.AllTablesThatNeedHelp();
    }

    public void needHelp(String tableNo){

        HELP_DB.needHelp(tableNo);
    }

    public void helped(String tableNo){

        HELP_DB.helped(tableNo);
    }
}