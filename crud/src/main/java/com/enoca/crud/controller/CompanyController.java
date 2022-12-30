package com.enoca.crud.controller;

import com.enoca.crud.entity.Company;
import com.enoca.crud.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller class for handling company related HTTP requests
@RestController
@RequestMapping(value = "/company", headers = "Accept=application/json")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    // Add a new company
    @PostMapping(value = "/save")
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        Company addCompany = companyService.addCompany(company);
        return  new ResponseEntity<Company>(addCompany, HttpStatus.CREATED);
    }

    // Get all companies
    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllWorker(){
        List<Company> allCompany = companyService.findAllCompany();
        return new ResponseEntity<List<Company>>(allCompany,HttpStatus.OK);
    }

    // Get a company by id
    @GetMapping("{id}")
    public ResponseEntity<Company> getCompanyId(@PathVariable("id") Long id){
        Company companyById = companyService.getCompanyById(id);
        return new ResponseEntity<Company>(companyById,HttpStatus.OK);
    }

    // Delete a company by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWorkerById(@PathVariable("id") Long id){
        companyService.deleteCompanyById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}