package com.csriseupapi.csriseupapi.controller;

import com.csriseupapi.csriseupapi.model.Status;
import com.csriseupapi.csriseupapi.repository.StatusRepository;
import com.csriseupapi.csriseupapi.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path= "/api")
public class StatusController {
    private StatusService statusService;
    private static final Logger LOGGER = Logger.getLogger(StatusController.class.getName());

    @Autowired
    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping("/statuses")
    public Status createStatus(@RequestBody Status statusObject){
        LOGGER.info("calling createStatus from controller");
        return statusService.createStatus(statusObject);
    }

    @GetMapping("/statuses")
    public List<Status> getStatuses(){
        LOGGER.info("calling getStatuses from controller");
        return statusService.getStatuses();
    }

}
