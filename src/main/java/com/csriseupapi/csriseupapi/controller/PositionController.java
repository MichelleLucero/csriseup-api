package com.csriseupapi.csriseupapi.controller;

import com.csriseupapi.csriseupapi.repository.JobRepository;
import com.csriseupapi.csriseupapi.repository.PositionRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(path= "/api")
public class PositionController {
    private PositionRepository positionRepository;
    private static final Logger LOGGER = Logger.getLogger(PositionController.class.getName());
}
