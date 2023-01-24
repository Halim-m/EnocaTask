package com.enoca.crud.dto.converter;

import com.enoca.crud.dto.CompanyDto;
import com.enoca.crud.model.Company;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CompanyDtoConverter {

    private final CompanyWorkerDtoConverter converter;

    public CompanyDtoConverter(CompanyWorkerDtoConverter converter) {
        this.converter = converter;
    }

    public CompanyDto convert(Company from){
        return new CompanyDto(
                from.getCompany_id(),
                from.getName(),
                Optional.ofNullable(from.getWorkers())
                        .map(workers -> workers.stream()
                                .map(converter::convert)
                                .collect(Collectors.toList()))
                        .orElse(Collections.emptyList()));
    }
}

