package com.intelliguru.springdatajpa.validator.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationErrorDTO {
    private String errorMessage;
    private String errorLocation;
}
