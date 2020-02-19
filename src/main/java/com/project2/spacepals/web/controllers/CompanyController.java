package com.project2.spacepals.web.controllers;


import com.project2.spacepals.entities.Company;
import com.project2.spacepals.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController (CompanyService service){
        super();
        this.companyService = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Company> getCompanies(HttpServletRequest req){
        return companyService.getAllCompanies();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company getCompanyById(@PathVariable int id){
        return companyService.getCompanyById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Company register(@RequestBody Company company){
        return companyService.registerCompany(company);
    }
}
