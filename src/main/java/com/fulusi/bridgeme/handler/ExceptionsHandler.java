package com.fulusi.bridgeme.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.context.request.WebRequest;
import com.fulusi.bridgeme.constant.Message;
import com.fulusi.bridgeme.constant.Status;
import com.fulusi.bridgeme.dto.BeResponse;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        System.out.println(ex);
        return new ResponseEntity<>(new BeResponse(Status.FAILED, Message.EXCEPTION_MESSAGE),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
            org.springframework.http.HttpStatusCode status,WebRequest request) {
        return new ResponseEntity<>(new BeResponse(Status.FAILED, Message.RESOURCE_NOTFOUND), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers,
            org.springframework.http.HttpStatusCode status,WebRequest request) {
        return new ResponseEntity<>(new BeResponse(Status.FAILED, ex.getLocalizedMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }
    


    
}
