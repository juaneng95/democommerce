package com.beonit.minsait.democommerce.exception.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class FieldErrorDto extends ErrorDto {

    @Serial
    private static final long serialVersionUID = 1L;

    private Map<String, String> errorFields;

    public FieldErrorDto(String message, Map<String, String> errorFields) {
        super(message);
        this.errorFields = errorFields;
    }
}
