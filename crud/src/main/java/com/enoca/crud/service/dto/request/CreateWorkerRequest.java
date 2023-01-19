package com.enoca.crud.service.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateWorkerRequest {
    @NotNull(message = "Name must not be null.")
    private final String name;
    @NotNull(message = "Surname must not be null.")
    private final String surname;
    @NotNull(message = "Company_id must not be null.")
    @Positive(message = "Company_id must be greater than zero")
    private final Long company_id;
}
