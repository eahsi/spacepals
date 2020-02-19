package com.project2.spacepals.services;

import com.project2.spacepals.entities.Company;
import com.project2.spacepals.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository repo){
        super();
        this.companyRepository = repo;
    }

    @Transactional(readOnly = true)
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Company getCompanyById(int id){
        return companyRepository.findById(id);
    }

    @Transactional
    public Company registerCompany(Company newObj){
        return companyRepository.save(newObj);
    }
}
