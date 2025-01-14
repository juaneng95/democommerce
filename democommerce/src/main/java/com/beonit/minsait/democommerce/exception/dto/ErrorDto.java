package com.beonit.minsait.democommerce.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String message;
}
