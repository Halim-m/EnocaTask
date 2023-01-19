package com.enoca.crud.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

// Entity class representing a worker
@Entity
@Table(name = "worker")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Worker {
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long workerId;

    // Many workers can belong to one company
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    private String name;
    private String surname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Worker worker = (Worker) o;
        return workerId != null && Objects.equals(workerId, worker.workerId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}