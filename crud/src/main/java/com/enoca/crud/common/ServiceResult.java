package com.enoca.crud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceResult<T> {
    private T data;
    private boolean success;
    private String errorMessage;
}
