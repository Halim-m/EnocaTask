package com.enoca.crud.service.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCompanyRequest {
    @NotNull(message = "Name must not be null.")
    private final String name;
}

