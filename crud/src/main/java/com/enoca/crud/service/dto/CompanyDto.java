package com.enoca.crud.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.enoca.crud.model.Company} entity
 */
@Data

@AllArgsConstructor
@RequiredArgsConstructor
public class CompanyDto implements Serializable {

    private final Long company_id;
    private final String name;
    private List<CompanyWorkerDto> workers = null;
}