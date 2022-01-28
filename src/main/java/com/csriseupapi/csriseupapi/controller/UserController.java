package com.csriseupapi.csriseupapi.controller;

import com.csriseupapi.csriseupapi.repository.UserRepository;
import com.csriseupapi.csriseupapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class UserController {
    private UserService userService;
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
