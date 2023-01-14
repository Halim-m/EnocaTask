package com.enoca.crud.dto.converter;

import com.enoca.crud.dto.CompanyDto;
import com.enoca.crud.dto.CompanyWorkerDto;
import com.enoca.crud.model.Company;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
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
                from.getWorkers()!=null?
                        from.getWorkers()
                                .stream()
                                .map(converter::convert)
                                .collect(Collectors.toList()
                                ):
                        Collections.emptyList()
        );
                //null);
                //ToDo

    }
}

