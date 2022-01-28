package com.csriseupapi.csriseupapi.service;

import com.csriseupapi.csriseupapi.exception.InformationExistException;
import com.csriseupapi.csriseupapi.model.User;
import com.csriseupapi.csriseupapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {
    private UserRepository userRepository;
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User userObject){
        LOGGER.info("calling createUser method from service");
        if(!userRepository.existsByEmailAddress(userObject.getEmailAddress())){
            return userRepository.save(userObject);
        } else {
            throw new InformationExistException("user with email address " + userObject.getEmailAddress() + " is already exists");
        }

    }
}
