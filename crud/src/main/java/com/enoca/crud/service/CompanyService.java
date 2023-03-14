package com.enoca.crud.service;

import com.enoca.crud.Repository.CompanyRepository;
import com.enoca.crud.dto.CompanyDto;
import com.enoca.crud.dto.request.CreateCompanyRequest;
import com.enoca.crud.dto.converter.CompanyDtoConverter;
import com.enoca.crud.exception.CompanyNotFoundException;
import com.enoca.crud.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService implements ICompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyDtoConverter converter;

    public CompanyService(CompanyRepository companyRepository,
                          CompanyDtoConverter converter) {
        this.companyRepository = companyRepository;
        this.converter = converter;
    }

    // Add and return new company
    @Override
    public CompanyDto addCompany(CreateCompanyRequest createCompanyRequest){
        Company company = new Company();
        company.setName(createCompanyRequest.getName());
        Company model = companyRepository.save(company);
        return converter.convert(model);
    }

    // Return list of all companies
    @Override
    public List<CompanyDto> findAllCompany(){
        return companyRepository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    // Return company with given ID
    @Override
    public CompanyDto getCompanyById(Long companyId){
        return converter.convert(companyRepository.findById(companyId)
                .orElseThrow(
                        ()->new CompanyNotFoundException("Company could not find by id: " + companyId)
                )
        );
    }

    //Return company with given ID
    protected Company companyEntityById(Long companyId){
        return companyRepository.findById(companyId)
                .orElseThrow(
                        () -> new CompanyNotFoundException("Company could not find by id: " + companyId)
                );
    }

    // Delete company with given ID
    @Override
    public void deleteCompanyById(Long companyId){
         Optional<Company> company = companyRepository.findById(companyId);
         if(company.isPresent()){
             companyRepository.delete(company.get());
         }else {
             throw new CompanyNotFoundException("Company could not find by id: " + companyId);
         }
    }
}
