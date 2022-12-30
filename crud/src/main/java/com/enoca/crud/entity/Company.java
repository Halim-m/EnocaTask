package com.enoca.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

// Entity class representing a company
@Entity
@Table(name = "company")
@Data
public class Company {
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long company_id;

    private String name;

    // Company can have one or more workers
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker")
    private List<Worker> workers;

}