package com.fulusi.bridgeme.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "users")
public class User {
    
    @Id
    private String id;

    private String userName;

    private String firstName;

    private String lastName;

    private String status = "active";

    private String email;

    private String mobile;

    private List<Secret> secrets;
    
    @CreatedDate
    private Date createdAt;
    
    @LastModifiedDate
    private Date updatedAt;
    
    public User(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    } 

}
