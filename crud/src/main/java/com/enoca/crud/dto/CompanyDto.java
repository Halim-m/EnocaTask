package com.enoca.crud.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.enoca.crud.model.Company} entity
 */
@Data
@Nullable
@AllArgsConstructor
@RequiredArgsConstructor
public class CompanyDto implements Serializable {

    private final Long company_id;
    private final String name;
    private List<CompanyWorkerDto> workers = null;
}