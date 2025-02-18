package com.ltp.contacts.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice  // GLOBALISE CLASS FOR EXCEPTION HANDLING
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler { // SUPER CLASS FOR FIELD VALIDATION

    @ExceptionHandler(ContactNotFoundException.class)  // CATCHES THE EXCEPTION AUTOMATICALLY !
    public ResponseEntity<Object> handleContactNotFoundException(ContactNotFoundException ex){

        ErrorResponse response = new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        for(ObjectError error: ex.getBindingResult().getAllErrors()){
            System.out.println(error.getDefaultMessage());
        }
        ErrorResponse response = new ErrorResponse(Arrays.asList(
                ex.getBindingResult()
                        .getAllErrors()
                        .stream()
                        .map( ObjectError::getDefaultMessage)
                        .collect(Collectors.toList()).toString()
                ));
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }
}
