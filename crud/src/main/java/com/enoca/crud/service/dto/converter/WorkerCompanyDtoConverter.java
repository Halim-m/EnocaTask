package com.enoca.crud.service.dto.converter;

import com.enoca.crud.service.dto.WorkerCompanyDto;
import com.enoca.crud.model.Company;
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

