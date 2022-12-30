package com.enoca.crud.service;

import com.enoca.crud.Repository.CompanyRepository;
import com.enoca.crud.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired()
    private CompanyRepository companyRepository;

    // Add and return new company
    public Company addCompany(Company company){
        return companyRepository.save(company);
    }

    // Return list of all companies
    public List<Company> findAllCompany(){
        return companyRepository.findAll();
    }

    // Return company with given ID
    public Company getCompanyById(Long companyId){
        return companyRepository.findById(companyId).get();
    }

    // Delete company with given ID
    public void deleteCompanyById(Long companyId){
        companyRepository.deleteById(companyId);
    }
}
