package com.csriseupapi.csriseupapi.service;

import com.csriseupapi.csriseupapi.model.Job;
import com.csriseupapi.csriseupapi.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

public class JobService {
    private JobRepository jobRepository;
    private static final Logger LOGGER = Logger.getLogger(JobService.class.getName());

    @Autowired
    public void setJobRepository(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getJobs(){
        LOGGER.info("calling getJobs method from service");
        return jobRepository.findAll();
    }




}
