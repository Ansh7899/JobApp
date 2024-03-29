package com.example.JobApp.service;

import com.example.JobApp.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    Company findCompanyById(Long id);
    void createJob(Company company);
    Boolean deleteCompany(Long id);
    Boolean updateCompany(Long id, Company company);
}
