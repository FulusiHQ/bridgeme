package com.fulusi.bridgeme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fulusi.bridgeme.client.passport.PassportClient;
import com.fulusi.bridgeme.client.passport.dto.CreateUser;
import com.fulusi.bridgeme.client.passport.dto.PassportResponse;

@Service
public class PassportService {
    
    private final PassportClient passportClient;


    @Autowired
    public PassportService(PassportClient passportClient) {
        this.passportClient = passportClient;
    }

    public PassportResponse createUser(CreateUser createUser) {
        return passportClient.createUser(createUser);
    }
  
}
