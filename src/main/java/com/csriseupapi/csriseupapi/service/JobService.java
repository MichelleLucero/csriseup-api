package com.csriseupapi.csriseupapi.service;

import com.csriseupapi.csriseupapi.exception.InformationNotFoundException;
import com.csriseupapi.csriseupapi.model.Company;
import com.csriseupapi.csriseupapi.model.Job;
import com.csriseupapi.csriseupapi.model.Position;
import com.csriseupapi.csriseupapi.model.Request.JobRequest;
import com.csriseupapi.csriseupapi.model.Status;
import com.csriseupapi.csriseupapi.repository.CompanyRepository;
import com.csriseupapi.csriseupapi.repository.JobRepository;
import com.csriseupapi.csriseupapi.repository.PositionRepository;
import com.csriseupapi.csriseupapi.repository.StatusRepository;
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
    private PositionRepository positionRepository;
    private CompanyRepository companyRepository;
    private StatusRepository statusRepository;

    private static final Logger LOGGER = Logger.getLogger(JobService.class.getName());

    @Autowired
    public void setJobRepository(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Autowired
    public void setPositionRepository(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Autowired
    public void setStatusRepository(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Job> getJobs(){
        LOGGER.info("calling getJobs method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("HELLLLLLLLLLLO");
        System.out.println(userDetails.getUser().getId());
        List<Job> jobs = jobRepository.findByUserId(userDetails.getUser().getId());
//        if(jobs.isEmpty()){
//            throw new InformationNotFoundException("no categories found for user id " + userDetails.getUser().getId());
//        } else {
//            return jobs;
//        }
        return jobs;
    }

    public Job createJob(JobRequest jobRequestObject){
        LOGGER.info("calling createJob method from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Job job = new Job(jobRequestObject.getJobLink(), LocalDate.now(), true, userDetails.getUser());

        Position position = positionRepository.findByPosition(jobRequestObject.getPosition());
        Company company = companyRepository.findByCompany(jobRequestObject.getCompany());
        Status status = statusRepository.findByStatus(jobRequestObject.getStatus());
        if( position != null){
            job.setPosition(position);
        } else {
            Position addPosition = new Position(jobRequestObject.getPosition());
            positionRepository.save(addPosition);
            Position addPositionWithId = positionRepository.findByPosition(jobRequestObject.getPosition());
            job.setPosition(addPositionWithId);
        }
        if( company != null){
            job.setCompany(company);
        } else {
            Company addCompany = new Company(jobRequestObject.getCompany());
            companyRepository.save(addCompany);
            Company addCompanyWithId = companyRepository.findByCompany(jobRequestObject.getCompany());
            job.setCompany(addCompanyWithId);
        }
        if( status != null ){
            job.setStatus(status);
        } else {
            Status addStatus = new Status(jobRequestObject.getStatus());
            statusRepository.save(addStatus);
            Status addStatusWithId = statusRepository.findByStatus(jobRequestObject.getStatus());
            job.setStatus(addStatusWithId);
        }
        return jobRepository.save(job);
    }

    public Job getJob(Long jobId){
        LOGGER.info("calling getJob from service");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Job job = jobRepository.findByUserIdAndId(userDetails.getUser().getId(),jobId);
        System.out.println(job.getCompany());
        System.out.println(job.getJobLink());
        if(job != null){
            return job;
        } else {
            throw new InformationNotFoundException("job with id " + jobId + " does not exists");
        }
    }


}
