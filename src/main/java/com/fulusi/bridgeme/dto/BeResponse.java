package com.fulusi.bridgeme.dto;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeResponse {
    
    private String status;
    private String message;

    private HashMap <String, String> data;


    private List<String> errors;
    private String error;

    public BeResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public BeResponse(String status, String message, List<String> objects) {
        this.status = status;
        this.message = message;
        this.errors = objects;
    } 
    public BeResponse(String status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
    } 
}