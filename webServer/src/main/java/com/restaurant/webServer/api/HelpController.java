package com.restaurant.webServer.api;

import com.restaurant.webServer.model.Help;
import com.restaurant.webServer.service.HelpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/help")
@RestController
public class HelpController {
    private final HelpService HELP_SERVICE;

    @Autowired
    public HelpController(HelpService HELP_SERVICE) {
        this.HELP_SERVICE = HELP_SERVICE;
    }

    @GetMapping(path = "/tables")
    public List<Help> allTablesThatNeedHelp() {

        return HELP_SERVICE.AllTablesThatNeedHelp();
    }

    @GetMapping(path = "/needHelp/{tableNo}")
    public void needHelp(@PathVariable("tableNo") String tableNo) {

        HELP_SERVICE.needHelp(tableNo);
    }

    @GetMapping(path = "/helped/{tableNo}")
    public void helped(@PathVariable("tableNo")String tableNo){

        HELP_SERVICE.helped(tableNo);
    }
}