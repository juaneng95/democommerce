package com.beonit.minsait.democommerce.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * Error dto class.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto implements Serializable {

    /**
     * The serial version id.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The message.
     */
    private String message;
}
