package com.csriseupapi.csriseupapi.service;

import com.csriseupapi.csriseupapi.model.Company;
import com.csriseupapi.csriseupapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;
    private static final Logger LOGGER = Logger.getLogger(CompanyService.class.getName());

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
