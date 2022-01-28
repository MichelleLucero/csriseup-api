package com.csriseupapi.csriseupapi.controller;

import com.csriseupapi.csriseupapi.model.Job;
import com.csriseupapi.csriseupapi.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path= "/api")
public class JobController {
    private JobRepository jobRepository;
    private static final Logger LOGGER = Logger.getLogger(JobController.class.getName());

    @Autowired
    public void setJobRepository( JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    @GetMapping("/jobs")
    public List<Job> getJobs(){
        LOGGER.info("calling getJobs method from controller");
        return jobRepository.findAll();
    }

    @GetMapping("/jobs/{jobId}")
    public String getJob(@PathVariable Long jobId){
        LOGGER.info("calling getJob method from controller");
        return "getting the job with id of " + jobId;
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody String body){
        LOGGER.info("calling createJob method from controller");
        return "creating a job " + body;
    }

    @PutMapping("/jobs/{jobId}")
    public String updateJob(@PathVariable Long jobId, @RequestBody String body){
        LOGGER.info("calling updateJob method from controller");
        return "updating the job with id of " + jobId + " " + body;
    }

    @DeleteMapping("/jobs/{jobId}")
    public String deleteJob(@PathVariable(value = "jobId") Long jobId){
        LOGGER.info("calling deleteJob method from controller");
        return "deleting the job with the id of " + jobId;
    }
}
