package com.csriseupapi.csriseupapi.controller;

import com.csriseupapi.csriseupapi.model.Position;
import com.csriseupapi.csriseupapi.repository.JobRepository;
import com.csriseupapi.csriseupapi.repository.PositionRepository;
import com.csriseupapi.csriseupapi.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path= "/api")
public class PositionController {
    private PositionService positionService;
    private static final Logger LOGGER = Logger.getLogger(PositionController.class.getName());

    @Autowired
    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping("/positions")
    public Position createPosition(@RequestBody Position positionObject){
        LOGGER.info("calling createPosition from controller");
        return positionService.createPosition(positionObject);
    }

    @GetMapping("/positions")
    public List<Position> getPositions(){
        LOGGER.info("calling getPositions from controller");
        return positionService.getPositions();
    }
}
