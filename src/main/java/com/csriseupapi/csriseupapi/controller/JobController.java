package com.csriseupapi.csriseupapi.controller;

import com.csriseupapi.csriseupapi.repository.JobRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(path= "/api")
public class JobController {
    private JobRepository jobRepository;
    private static final Logger LOGGER = Logger.getLogger(JobController.class.getName());
}
