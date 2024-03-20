package com.fulusi.bridgeme.dto;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fulusi.bridgeme.constant.Status;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeResponse {

    protected String status;
    protected String message;
    protected String errorCode;

    protected HashMap<String, Object> data;

    protected List<String> errors;
    protected String error;

    public BeResponse() {
    };

    public BeResponse(String status) {
        this.status = status;
    };

    public BeResponse(String status, String errorCode) {
        this.status = status;
        this.errorCode = errorCode;
    }

    public BeResponse(String status, String errorCode, List<String> objects) {
        this.status = status;
        this.errorCode = errorCode;
        this.errors = objects;
    }

    public BeResponse(String status, String errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }

    @JsonIgnore
    public Boolean isSuccess() {
        return (this.status != null && this.status.equals(Status.SUCCESS)) ? true : false;
    }
}