package com.beonit.minsait.democommerce.exception.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.Map;

/**
 * Field error dto class.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class FieldErrorDto extends ErrorDto {

    /**
     * Serial version id.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The error fields.
     */
    private Map<String, String> errorFields;

    /**
     * Constructor.
     *
     * @param message     - The message.
     * @param errorFields - The error fields.
     */
    public FieldErrorDto(String message, Map<String, String> errorFields) {
        super(message);
        this.errorFields = errorFields;
    }
}
