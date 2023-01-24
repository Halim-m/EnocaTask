package com.enoca.crud.dto.converter;

import com.enoca.crud.dto.CompanyWorkerDto;
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
