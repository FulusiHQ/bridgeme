package com.fulusi.bridgeme.dto;

import java.util.HashMap;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fulusi.bridgeme.model.Setting;
import com.fulusi.bridgeme.model.User;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoResponse {
    
    private String status;
    private String message;

    private HashMap <String, String> data;

    private Setting setting;
    private List<Setting> settings;

    private User user;
    private List<User> users;  

    private Object[] errors;
    private String error;

    public MoResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public MoResponse(String status, String message, Object[] objects) {
        this.status = status;
        this.message = message;
        this.errors = objects;
    } 
    public MoResponse(String status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
    } 
}