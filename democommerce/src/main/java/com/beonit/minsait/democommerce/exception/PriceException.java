package com.beonit.minsait.democommerce.exception;

import lombok.Getter;

import java.io.Serial;


/**
 * Price exception class.
 */
@Getter
public abstract class PriceException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    private final int code;

    /**
     * Instantiates a new Price exception.
     *
     * @param code    the code
     * @param message the message
     */
    protected PriceException(int code, String message) {
        super(message);
        this.code = code;
    }
}
