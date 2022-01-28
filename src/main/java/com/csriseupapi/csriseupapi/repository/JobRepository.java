package com.csriseupapi.csriseupapi.repository;

import com.csriseupapi.csriseupapi.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
