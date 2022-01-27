package com.csriseupapi.csriseupapi.model;

import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

public class Job {
    private Long id;
    private Position position;
    private Company company;
    private String jobLink;
    private Status status;
    private LocalDate lastUpdated;
    private boolean open;
    private User user;
}
