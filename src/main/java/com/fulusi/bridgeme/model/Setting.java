package com.fulusi.bridgeme.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Document(collection = "settings")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Setting {
    @Id
    @Transient
    private String id;
    
    private String name;

    private Object value;

    @CreatedDate
    private Date createdAt;
    
    @LastModifiedDate
    private Date updatedAt;

    private int version = 1;

    public Setting(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}