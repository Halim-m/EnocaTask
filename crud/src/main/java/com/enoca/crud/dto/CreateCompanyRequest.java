package com.enoca.crud.dto;


import lombok.Data;

@Data
public class CreateCompanyRequest {
    private final String name;

    public CreateCompanyRequest(String name) {
        this.name = name;
    }
}

