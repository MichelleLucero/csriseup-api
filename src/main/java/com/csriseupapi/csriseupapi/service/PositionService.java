package com.csriseupapi.csriseupapi.service;

import com.csriseupapi.csriseupapi.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PositionService {
    private PositionRepository positionRepository;
    private static final Logger LOGGER = Logger.getLogger(PositionService.class.getName());

    @Autowired
    public void setPositionRepository(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }
}
