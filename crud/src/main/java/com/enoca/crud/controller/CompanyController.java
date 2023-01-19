package com.enoca.crud.controller;

import com.enoca.crud.service.dto.CompanyDto;
import com.enoca.crud.service.dto.request.CreateCompanyRequest;
import com.enoca.crud.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller class for handling company related HTTP requests
@RestController
@RequestMapping(value = "/company", headers = "Accept=application/json")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // Add a new company
    @PostMapping(value = "/save")
    public ResponseEntity<CompanyDto> addCompany(@Valid @RequestBody CreateCompanyRequest createCompanyRequest){
        CompanyDto addCompany = companyService.addCompany(createCompanyRequest);
        return  new ResponseEntity<CompanyDto>(addCompany, HttpStatus.CREATED);
    }

    // Get all companies
    @GetMapping("/all")
    public ResponseEntity<List<CompanyDto>> getAllWorker(){
        List<CompanyDto> allCompany = companyService.findAllCompany();
        return new ResponseEntity<List<CompanyDto>>(allCompany,HttpStatus.OK);
    }

    // Get a company by id
    @GetMapping("{id}")
    public ResponseEntity<CompanyDto> getCompanyId(@PathVariable("id") Long id){
        CompanyDto companyById = companyService.getCompanyById(id);
        return new ResponseEntity<CompanyDto>(companyById,HttpStatus.OK);
    }

    // Delete a company by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWorkerById(@PathVariable("id") Long id){
        companyService.deleteCompanyById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}