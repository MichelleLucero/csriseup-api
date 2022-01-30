package com.csriseupapi.csriseupapi.service;

import com.csriseupapi.csriseupapi.exception.InformationExistException;
import com.csriseupapi.csriseupapi.model.Position;
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

    public Position createPosition(Position positionObject){
        Position position = positionRepository.findByPosition(positionObject.getPosition());
        if( position != null){
            throw new InformationExistException("Company " + positionObject.getPosition() + " already exits in DB" );
        }else {
            return positionRepository.save(positionObject);
        }
    }
}
