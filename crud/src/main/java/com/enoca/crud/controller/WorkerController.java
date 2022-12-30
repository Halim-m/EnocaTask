package com.enoca.crud.controller;

import com.enoca.crud.entity.Worker;
import com.enoca.crud.service.CompanyService;
import com.enoca.crud.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller class for handling worker related HTTP requests
@RestController()
@RequestMapping(value = "/worker",headers = "Accept=application/json")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    // Add a new worker
    @PostMapping(value = "/save")
    public ResponseEntity<Worker> addWorker(@RequestBody Worker worker){
        Worker addWorker = workerService.addWorker(worker);
        return  new ResponseEntity<Worker>(addWorker, HttpStatus.CREATED);
    }

    // Get all workers
    @GetMapping("/all")
    public ResponseEntity<List<Worker>> getAllWorker(){
        List<Worker> allWorker = workerService.findAllWorker();
        return new ResponseEntity<List<Worker>>(allWorker,HttpStatus.OK);
    }

    // Get a worker by id
    @GetMapping("{id}")
    public ResponseEntity<Worker> getWorkerId(@PathVariable("id") Long id){
        Worker workerById = workerService.getWorkerById(id);
        return new ResponseEntity<Worker>(workerById,HttpStatus.OK);
    }

    // Delete a worker by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWorkerById(@PathVariable("id") Long id){
        workerService.deleteWorkerById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
