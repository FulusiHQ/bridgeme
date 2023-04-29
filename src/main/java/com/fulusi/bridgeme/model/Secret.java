package com.fulusi.bridgeme.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Secret {

    private String type;

    @JsonIgnore
    private String secret;

    private String status = "active";

    @CreatedDate
    private Date createdAt = new Date();

    public Secret (String type, String secret) {
        this.type = type;
        this.secret = secret;
    }
}
