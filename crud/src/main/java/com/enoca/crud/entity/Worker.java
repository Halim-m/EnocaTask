package com.enoca.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import lombok.Data;
import lombok.ToString;

// Entity class representing a worker
@Entity
@Table(name = "worker")
@Data
@ToString
public class Worker {
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long workerId;

    // Many workers can belong to one company
    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;

    private String name;
    private String surname;

}