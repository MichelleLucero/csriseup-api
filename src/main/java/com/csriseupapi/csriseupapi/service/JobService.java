package com.csriseupapi.csriseupapi.service;

import com.csriseupapi.csriseupapi.exception.InformationNotFoundException;
import com.csriseupapi.csriseupapi.model.Job;
import com.csriseupapi.csriseupapi.repository.JobRepository;
import com.csriseupapi.csriseupapi.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.time.*;

@Service
public class JobService {
    private JobRepository jobRepository;
    private static final Logger LOGGER = Logger.getLogger(JobService.class.getName());

    @Autowired
    public void setJobRepository(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getJobs(){
        LOGGER.info("calling getJobs method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("HELLLLLLLLLLLO");
        System.out.println(userDetails.getUser().getId());
        List<Job> jobs = jobRepository.findByUserId(userDetails.getUser().getId());
        if(jobs.isEmpty()){
            throw new InformationNotFoundException("no categories found for user id " + userDetails.getUser().getId());
        } else {
            return jobs;
        }
    }

    public Job createJob(Job jobObject){
        LOGGER.info("calling createJob method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Job job = jobRepository.findByUserIdAndPositionIdAndCompanyId(
//                userDetails.getUser().getId(),
//                jobObject.getPosition().getId(),
//                jobObject.getCompany().getId());
        jobObject.setUser(userDetails.getUser());
        jobObject.setLastUpdated(LocalDate.now());
        jobObject.setOpen(true);
        return jobRepository.save(jobObject);

    }




}
