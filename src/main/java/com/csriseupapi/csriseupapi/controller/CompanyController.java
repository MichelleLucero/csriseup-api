package com.csriseupapi.csriseupapi.controller;

import com.csriseupapi.csriseupapi.model.Company;
import com.csriseupapi.csriseupapi.repository.CompanyRepository;
import com.csriseupapi.csriseupapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path= "/api")
public class CompanyController {
    private CompanyService companyService;
    private static final Logger LOGGER = Logger.getLogger(CompanyController.class.getName());

    @Autowired
    public void setCompanyRepository( CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public List<Company> getCompanies(){
        LOGGER.info("calling getCompanies method from controller");
        return companyService.getCompanies();
    }

//    @GetMapping("/companies/{companyId}")
//    public String getCompany(@PathVariable Long companyId){
//        LOGGER.info("calling getCompany method from controller");
//        return "getting the company with id of " + companyId;
//    }

    @PostMapping("/companies")
    public Company createCompany(@RequestBody Company companyObject){
        LOGGER.info("calling createCompany method from controller");
        return companyService.createCompany(companyObject);
    }

    @PutMapping("/companies/{companyId}")
    public String updateCompany(@PathVariable Long companyId, @RequestBody String body){
        LOGGER.info("calling updateCompany method from controller");
        return "updating the company with id of " + companyId + " " + body;
    }

    @DeleteMapping("/companies/{companyId}")
    public String deleteCompany(@PathVariable(value = "companyId") Long companyId){
        LOGGER.info("calling deleteCompany method from controller");
        return "deleting the company with the id of " + companyId;
    }

}
