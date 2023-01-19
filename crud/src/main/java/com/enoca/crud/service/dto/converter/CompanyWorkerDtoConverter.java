package com.enoca.crud.service.dto.converter;

import com.enoca.crud.service.dto.CompanyWorkerDto;
import com.enoca.crud.model.Worker;
import org.springframework.stereotype.Component;

@Component
public class CompanyWorkerDtoConverter {
    protected CompanyWorkerDto convert(Worker from){
        return new CompanyWorkerDto(
                from.getWorkerId(),
                from.getName(),
                from.getSurname()
        );
    }
}
