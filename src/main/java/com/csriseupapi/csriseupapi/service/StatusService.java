package com.csriseupapi.csriseupapi.service;

import com.csriseupapi.csriseupapi.exception.InformationExistException;
import com.csriseupapi.csriseupapi.model.Status;
import com.csriseupapi.csriseupapi.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class StatusService {
    private StatusRepository statusRepository;
    private static final Logger LOGGER = Logger.getLogger(StatusService.class.getName());

    @Autowired
    public void setStatusRepository(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status createStatus(Status statusObject){
        LOGGER.info("calling createStatus from service");
        Status status = statusRepository.findByStatus(statusObject.getStatus());
        if(status != null){
            throw new InformationExistException(statusObject.getStatus() + " already exists in the DB");
        } else {
            return statusRepository.save(statusObject);
        }
    }
}
