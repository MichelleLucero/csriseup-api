package com.csriseupapi.csriseupapi.repository;

import com.csriseupapi.csriseupapi.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findByStatus(String statusName);
}
