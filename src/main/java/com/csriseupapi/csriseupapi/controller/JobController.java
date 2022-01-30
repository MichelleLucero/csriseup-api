package com.csriseupapi.csriseupapi.controller;

import com.csriseupapi.csriseupapi.model.Job;
import com.csriseupapi.csriseupapi.model.Request.JobRequest;
import com.csriseupapi.csriseupapi.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path= "/api")
public class JobController {
    private JobService jobService;
    private static final Logger LOGGER = Logger.getLogger(JobController.class.getName());

    @Autowired
    public void setJobService( JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> getJobs(){
        LOGGER.info("calling getJobs method from controller");
        return jobService.getJobs();
    }

    @PostMapping("/jobs")
    public Job createJob(@RequestBody JobRequest jobRequestObject){
        LOGGER.info("calling createJob method from controller");
        return jobService.createJob(jobRequestObject);
    }

    @GetMapping("/jobs/{jobId}")
    public Job getJob(@PathVariable Long jobId){
        LOGGER.info("calling getJob method from controller");
        return jobService.getJob(jobId);
    }

    @PutMapping("/jobs/{jobId}")
    public Job updateJob(@PathVariable Long jobId, @RequestBody JobRequest jobRequestObject){
        LOGGER.info("calling updateJob method from controller");
        return jobService.updateJob(jobId, jobRequestObject);
    }

//    @DeleteMapping("/jobs/{jobId}")
//    public Job deleteJob(@PathVariable(value = "jobId") Long jobId){
//        LOGGER.info("calling deleteJob method from controller");
//        return jobService.deleteJob(jobId);
//    }
}
