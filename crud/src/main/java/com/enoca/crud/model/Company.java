package com.enoca.crud.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

// Entity class representing a company
@Entity
@Table(name = "company")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long company_id;

    private String name;

    // Company can have one or more workers
    @OneToMany(targetEntity = Worker.class, cascade = CascadeType.ALL, mappedBy = "company")
    @ToString.Exclude
    private List<Worker> workers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Company company = (Company) o;
        return company_id != null && Objects.equals(company_id, company.company_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}