package com.enoca.crud.dto;

import lombok.Data;

import java.io.Serializable;


/**
 * A DTO for the {@link com.enoca.crud.model.Worker} entity
 */
@Data
public class CompanyWorkerDto implements Serializable {
    private final Long workerId;
    private final String name;
    private final String surname;

    public CompanyWorkerDto(Long workerId, String name, String surname) {
        this.workerId=workerId;
        this.name=name;
        this.surname=surname;
    }
}