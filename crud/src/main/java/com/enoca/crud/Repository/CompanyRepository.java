package com.enoca.crud.Repository;

import com.enoca.crud.model.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}