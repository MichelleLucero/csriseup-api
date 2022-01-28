package com.csriseupapi.csriseupapi.service;

import com.csriseupapi.csriseupapi.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class StatusService {
    private StatusRepository statusRepository;
    private static final Logger LOGGER = Logger.getLogger(StatusService.class.getName());

    public void setStatusRepository(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
}
