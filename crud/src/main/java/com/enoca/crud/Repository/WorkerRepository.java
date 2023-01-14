package com.enoca.crud.Repository;


import com.enoca.crud.model.Worker;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}