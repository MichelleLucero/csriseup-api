package com.csriseupapi.csriseupapi.controller;

import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(path= "/api")
public class CompanyController {
    private static final Logger LOGGER = Logger.getLogger(CompanyController.class.getName());

    @GetMapping("/companies")
    public String getCompanies(){
        return "get all companies";
    }

    @GetMapping("/companies/{companyId}")
    public String getCompany(@PathVariable Long companyId){
        return "getting the company with id of " + companyId;
    }

    @PostMapping("/companies")
    public String createCompany(@RequestBody String body){
        return "creating a company " + body;
    }

    @PutMapping("/companies/{companyId}")
    public String updateCompany(@PathVariable Long companyId, @RequestBody String body){
        LOGGER.info("calling updateCompany method from controller");
        return "updating the company with id of " + companyId + " " + body;
    }

    @DeleteMapping("/companies/{companyId}")
    public String deleteCompany(@PathVariable(value = "companyId") Long companyId){
        return "deleting the company with the id of " + companyId;
    }

}
