package com.enoca.crud.dto.converter;

import com.enoca.crud.dto.WorkerDto;
import com.enoca.crud.model.Worker;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class WorkerDtoConverter {
    private final WorkerCompanyDtoConverter converter;

    public WorkerDtoConverter(WorkerCompanyDtoConverter converter) {
        this.converter = converter;
    }

    public WorkerDto convert(Worker from){
        return new WorkerDto(
                Objects.requireNonNull(from.getWorkerId()),
                converter.convert(from.getCompany()),
                from.getName(),
                from.getSurname()
        );
    }
}