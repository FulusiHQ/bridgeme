package com.fulusi.bridgeme.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.context.request.WebRequest;
import com.fulusi.bridgeme.constant.ErrorCode;
import com.fulusi.bridgeme.constant.Status;
import com.fulusi.bridgeme.dto.BeResponse;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        System.out.println(ex);
        return new ResponseEntity<>(new BeResponse(Status.FAILED, ex.getMessage() , "Unable to process request"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
            org.springframework.http.HttpStatusCode status,WebRequest request) {
        return new ResponseEntity<>(new BeResponse(Status.FAILED, ErrorCode.RESOURCE_NOTFOUND), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers,
            org.springframework.http.HttpStatusCode status,WebRequest request) {
        return new ResponseEntity<>(new BeResponse(Status.FAILED, ex.getLocalizedMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }
    
     @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
            org.springframework.http.HttpStatusCode status,WebRequest request) {
             List<String> errors = new ArrayList<>();
        
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            errors.add(fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>( new BeResponse(Status.FAILED, ErrorCode.BAD_REQUEST,errors), HttpStatus.BAD_REQUEST);
    }

    
}
