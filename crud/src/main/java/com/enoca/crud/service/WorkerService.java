package com.enoca.crud.service;

import com.enoca.crud.Repository.WorkerRepository;
import com.enoca.crud.service.dto.request.CreateWorkerRequest;
import com.enoca.crud.service.dto.WorkerDto;
import com.enoca.crud.service.dto.converter.WorkerDtoConverter;
import com.enoca.crud.exception.WorkerNotFoundException;
import com.enoca.crud.model.Company;
import com.enoca.crud.model.Worker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerService implements IWorkerService{
    private final WorkerRepository workerRepository;
    private final WorkerDtoConverter converter;
    private final CompanyService companyService;
    public WorkerService(WorkerRepository workerRepository,
                         WorkerDtoConverter converter,
                         CompanyService companyService) {
        this.workerRepository = workerRepository;
        this.converter = converter;
        this.companyService = companyService;
    }

    // Add and return new worker
    @Override
    public WorkerDto addWorker(CreateWorkerRequest createWorkerRequest){
        Company company = companyService.companyEntityById(createWorkerRequest.getCompany_id());
        Worker worker = new Worker();
        worker.setName(createWorkerRequest.getName());
        worker.setSurname(createWorkerRequest.getSurname());
        worker.setCompany(company);
        Worker model = workerRepository.save(worker);
        return converter.convert(model);
    }

    // Return list of all workers
    @Override
    public List<WorkerDto> findAllWorker(){
        return workerRepository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    // Return worker with given ID
    @Override
    public WorkerDto getWorkerById(Long workerId){
        return converter.convert(workerRepository.findById(workerId)
                .orElseThrow(
                        ()-> new WorkerNotFoundException("Worker could not find by id: " + workerId)
                )
        );
    }

    // Delete worker with given ID
    @Override
    public void deleteWorkerById(Long workerId){
        workerRepository.findById(workerId)
                .orElseThrow(
                        ()-> new WorkerNotFoundException("Worker could not find by id: " + workerId)
                );
        workerRepository.deleteById(workerId);
    }
}
