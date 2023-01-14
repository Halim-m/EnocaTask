package com.enoca.crud.service;

import com.enoca.crud.dto.CompanyDto;
import com.enoca.crud.dto.CreateCompanyRequest;

import java.util.List;

public interface ICompanyService {
    // Add and return new company
    CompanyDto addCompany(CreateCompanyRequest createCompanyRequest);

    // Return list of all companies
    List<CompanyDto> findAllCompany();

    // Return company with given ID
    CompanyDto getCompanyById(Long companyId);

    // Delete company with given ID
    void deleteCompanyById(Long companyId);
}
