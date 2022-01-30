package com.csriseupapi.csriseupapi.service;

import com.csriseupapi.csriseupapi.exception.InformationExistException;
import com.csriseupapi.csriseupapi.model.Company;
import com.csriseupapi.csriseupapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;
    private static final Logger LOGGER = Logger.getLogger(CompanyService.class.getName());

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies(){
        LOGGER.info("calling getCompanies method from service");
        return companyRepository.findAll();
    }

    public Company createCompany(Company companyObject){
        Company company = companyRepository.findByCompany(companyObject.getCompany());
        if( company != null){
            throw new InformationExistException("Company " + companyObject.getCompany() + " already exits in DB" );
        }else {
            return companyRepository.save(companyObject);
        }
    }

}
