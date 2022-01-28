package com.csriseupapi.csriseupapi.repository;

import com.csriseupapi.csriseupapi.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
