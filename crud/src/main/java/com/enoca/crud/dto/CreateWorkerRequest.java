package com.enoca.crud.dto;

import lombok.Data;

@Data
public class CreateWorkerRequest {
    //ToDo
    private final String name;
    private final String surname;
    private final Long company_id;
}
