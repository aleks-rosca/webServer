package com.restaurant.webServer.api;

import com.restaurant.webServer.model.Income;
import com.restaurant.webServer.model.Log;
import com.restaurant.webServer.model.LogQuantityBought;
import com.restaurant.webServer.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/logs")
@RestController
public class LogsController {
private final LogsService logsService;

@Autowired
    public LogsController(LogsService logsService){this.logsService=logsService;}
@GetMapping(path="Log")
    public List<Log> getAllLog(){return logsService.getAllLog();}
    @GetMapping(path="LogQuantityBought")
    public List<LogQuantityBought> getAllLogQuantityBought(){return logsService.getAllLogQuantityBought();}
    @GetMapping(path="Income")
    public Income getTotalIncome(){return logsService.getTotalIncom();}
}
