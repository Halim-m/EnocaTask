package com.enoca.crud.service;

import com.enoca.crud.dto.CreateWorkerRequest;
import com.enoca.crud.dto.WorkerDto;
import com.enoca.crud.model.Worker;

import java.util.List;

public interface IWorkerService {
    // Add and return new company

    WorkerDto addWorker(CreateWorkerRequest createWorkerRequest);

    // Return list of all companies
    List<WorkerDto> findAllWorker();

    // Return company with given ID
    WorkerDto getWorkerById(Long companyId);

    // Delete company with given ID
    void deleteWorkerById(Long companyId);
}