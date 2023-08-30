package com.fulusi.bridgeme.client.passport.dto;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PassportSecret {
    private String type;

    @JsonIgnore
    private String secret;

    private String status = "active";

    @CreatedDate
    private Date createdAt = new Date();
}
