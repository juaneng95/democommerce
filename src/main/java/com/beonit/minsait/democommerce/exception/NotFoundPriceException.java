package com.beonit.minsait.democommerce.exception;

import java.io.Serial;

/**
 * Not found price exception class.
 */
public class NotFoundPriceException extends PriceException {

    /**
     * The serial version id.
     */
    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * Instantiates a new Not found price exception.
     *
     * @param message the message
     */
    public NotFoundPriceException(String message) {

        super(404, message);
    }
}
