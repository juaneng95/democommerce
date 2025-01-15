package com.beonit.minsait.democommerce.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Api exception handler class
 */
@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ApiExceptionHandler {

    /**
     * Method to manage the unhandled errors.
     *
     * @param e - The exception.
     * @return The response entity with the message and status 500.
     */
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity unhandledErrors(final Exception e) {
        log.error("error - {} - {}", e.getMessage(), e.getStackTrace());
        return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
