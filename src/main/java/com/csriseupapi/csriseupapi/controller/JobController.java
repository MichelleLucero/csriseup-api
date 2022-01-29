package com.csriseupapi.csriseupapi.controller;

import com.csriseupapi.csriseupapi.model.Job;
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

    @GetMapping("/jobs/{jobId}")
    public String getJob(@PathVariable Long jobId){
        LOGGER.info("calling getJob method from controller");
        return "getting the job with id of " + jobId;
    }

//    @PostMapping("/jobs")
//    public Job createJob(@RequestBody Job jobObject){
//        LOGGER.info("calling createJob method from controller");
//        return jobService.createJob(jobObject);
//    }

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
