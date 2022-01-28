package com.csriseupapi.csriseupapi.controller;

import com.csriseupapi.csriseupapi.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(path= "/api")
public class StatusController {
    private StatusRepository statusRepository;
    private static final Logger LOGGER = Logger.getLogger(StatusController.class.getName());

    @Autowired
    public void setStatusRepository(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
}
