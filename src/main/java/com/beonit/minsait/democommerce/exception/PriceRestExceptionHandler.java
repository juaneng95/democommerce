package com.beonit.minsait.democommerce.exception;

import com.beonit.minsait.democommerce.exception.dto.ErrorDto;
import com.beonit.minsait.democommerce.exception.dto.FieldErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Price rest exception handler.
 */
@ControllerAdvice
public class PriceRestExceptionHandler {

    private PriceRestExceptionHandler() {
    }

    /**
     * Unhandled exceptions response entity.
     *
     * @param req the req
     * @param ex  the ex
     * @return the response entity
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public static ResponseEntity<ErrorDto> unhandledExceptions(HttpServletRequest req, Exception ex) {

        return ResponseEntity.internalServerError().body(new ErrorDto(ex.getMessage()));
    }

    /**
     * Handle price custom exceptions response entity.
     *
     * @param req the req
     * @param res the res
     * @param ex  the ex
     * @return the response entity
     */
    @ExceptionHandler({PriceException.class})
    @ResponseBody
    public static ResponseEntity<ErrorDto> handlePriceCustomExceptions(
            HttpServletRequest req, HttpServletResponse res, PriceException ex) {

        res.setStatus(ex.getCode());
        return ResponseEntity.status(ex.getCode()).body(new ErrorDto(ex.getMessage()));
    }

    /**
     * Handle method mismatch exceptions response entity.
     *
     * @param req the req
     * @param ex  the ex
     * @return the response entity
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public static ResponseEntity<ErrorDto> handleMethodMismatchExceptions(
            HttpServletRequest req, MethodArgumentTypeMismatchException ex) {

        return ResponseEntity.badRequest().body(new ErrorDto(ex.getMessage()));
    }

    /**
     * Handle media type not supported exceptions response entity.
     *
     * @param req the req
     * @param ex  the ex
     * @return the response entity
     */
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public static ResponseEntity<ErrorDto> handleMediaTypeNotSupportedExceptions(
            HttpServletRequest req, HttpMediaTypeNotSupportedException ex) {

        return ResponseEntity.badRequest().body(new ErrorDto(ex.getMessage()));
    }

    /**
     * Handle validation exceptions response entity.
     *
     * @param req the req
     * @param ex  the ex
     * @return the response entity
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public static ResponseEntity<FieldErrorDto> handleValidationExceptions(
            HttpServletRequest req, MethodArgumentNotValidException ex) {

        Map<String, String> errorList = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(err -> errorList.put(err.getField(), err.getDefaultMessage()));

        return ResponseEntity.badRequest().body(new FieldErrorDto(ex.getBody().getDetail(), errorList));
    }
}
