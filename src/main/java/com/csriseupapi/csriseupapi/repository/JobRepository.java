package com.csriseupapi.csriseupapi.repository;

import com.csriseupapi.csriseupapi.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByUserId(Long userId);
    Job findByUserIdAndId(Long userId, Long Id);


}
