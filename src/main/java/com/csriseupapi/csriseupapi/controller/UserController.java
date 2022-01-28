package com.csriseupapi.csriseupapi.controller;

import com.csriseupapi.csriseupapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class UserController {
    private UserRepository userRepository;
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
