package com.enoca.crud.dto;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.enoca.crud.model.Worker} entity
 */
@Data
@Nullable
public class WorkerDto implements Serializable {
    private final Long workerId;
    private final WorkerCompanyDto company;
    private final String name;
    private final String surname;

    public WorkerDto(Long workerId, WorkerCompanyDto convert, String name, String surname) {
        this.workerId=workerId;
        this.company=convert;
        this.name=name;
        this.surname=surname;
    }
}