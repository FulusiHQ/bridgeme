package com.fulusi.bridgeme.client.passport.dto;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public class PassportUser {

    private String id;

    private String userName;

    private String firstName;

    private String lastName;

    private String status = "active";

    private String email;

    private String mobile;

    private List<PassportSecret> secrets;
    
    @CreatedDate
    private Date createdAt;
    
    @LastModifiedDate
    private Date updatedAt;
}
