package com.enoca.crud.dto;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.enoca.crud.model.Company} entity
 */
@Data
@Nullable
public class WorkerCompanyDto implements Serializable {
    private final Long company_id;
    private final String name;

    public WorkerCompanyDto(Long company_id, String name) {
        this.company_id= company_id;
        this.name=name;
    }
}