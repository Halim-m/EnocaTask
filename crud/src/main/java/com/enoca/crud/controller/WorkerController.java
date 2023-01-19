package com.enoca.crud.controller;

import com.enoca.crud.service.dto.request.CreateWorkerRequest;
import com.enoca.crud.service.dto.WorkerDto;
import com.enoca.crud.service.WorkerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller class for handling worker related HTTP requests
@RestController()
@RequestMapping(value = "/worker",headers = "Accept=application/json")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    // Add a new worker
    @PostMapping(value = "/save")
    public ResponseEntity<WorkerDto> addWorker(@Valid @RequestBody CreateWorkerRequest createWorkerRequest){
        WorkerDto addWorker = workerService.addWorker(createWorkerRequest);
        return  new ResponseEntity<WorkerDto>(addWorker, HttpStatus.CREATED);
    }

    // Get all workers
    @GetMapping("/all")
    public ResponseEntity<List<WorkerDto>> getAllWorker(){
        List<WorkerDto> allWorker = workerService.findAllWorker();
        return new ResponseEntity<List<WorkerDto>>(allWorker,HttpStatus.OK);
    }

    // Get a worker by id
    @GetMapping("{id}")
    public ResponseEntity<WorkerDto> getWorkerId(@PathVariable("id") Long id){
        WorkerDto workerById = workerService.getWorkerById(id);
        return new ResponseEntity<WorkerDto>(workerById,HttpStatus.OK);
    }

    // Delete a worker by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWorkerById(@PathVariable("id") Long id){
        workerService.deleteWorkerById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
