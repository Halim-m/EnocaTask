package com.enoca.crud.dto.converter;

import com.enoca.crud.dto.WorkerCompanyDto;
import com.enoca.crud.model.Company;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class WorkerCompanyDtoConverter {
    protected WorkerCompanyDto convert(Company from){
        return new WorkerCompanyDto(
                from.getCompany_id(),
                from.getName()
        );
    }
}

