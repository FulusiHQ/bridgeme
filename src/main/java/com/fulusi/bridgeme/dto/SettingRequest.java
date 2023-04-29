package com.fulusi.bridgeme.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SettingRequest {
    
    private int version;

    @NotNull(message = "name cannot be null")
    private String name;

    @NotNull(message = "value cannot be null")
    private String value;
}
