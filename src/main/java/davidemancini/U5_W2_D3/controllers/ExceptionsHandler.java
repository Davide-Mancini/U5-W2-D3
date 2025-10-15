package davidemancini.U5_W2_D3.controllers;

import davidemancini.U5_W2_D3.exceptions.NotFoundExceptions;
import davidemancini.U5_W2_D3.payloads.ErrorsPayload;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NotFoundExceptions.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayload handleNotFound(NotFoundExceptions ex){
        return new ErrorsPayload(ex.getMessage(), LocalDateTime.now());
    }
}

