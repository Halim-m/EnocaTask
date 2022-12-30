package com.enoca.crud.service;

import com.enoca.crud.Repository.WorkerRepository;
import com.enoca.crud.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired()
    private WorkerRepository workerRepository;

    // Add and return new worker
    public Worker addWorker(Worker worker){
        return workerRepository.save(worker);
    }

    // Return list of all workers
    public List<Worker> findAllWorker(){
        return workerRepository.findAll();
    }

    // Return worker with given ID
    public Worker getWorkerById(Long workerId){
        return workerRepository.findById(workerId).get();
    }

    // Delete worker with given ID
    public void deleteWorkerById(Long workerId){
        workerRepository.deleteById(workerId);
    }
}
