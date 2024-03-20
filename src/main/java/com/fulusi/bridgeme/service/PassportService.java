package com.fulusi.bridgeme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fulusi.bridgeme.client.passport.PassportClient;
import com.fulusi.bridgeme.client.passport.dto.*;

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

    public PassportResponse updateSecret(String userId, String type, String secret) {
        UpdateSecret updateSecret = new UpdateSecret();
        updateSecret.setUserId(userId);
        updateSecret.setSecretType(type);
        updateSecret.setSecret(secret);
        return passportClient.updateSecret(updateSecret);
    }

    public PassportResponse changeSecret(String userId, String type, String oldSecret, String newSecret) {
        ChangeSecret changeSecret = new ChangeSecret();
        changeSecret.setUserId(userId);
        changeSecret.setSecretType(type);
        changeSecret.setOldSecret(oldSecret);
        changeSecret.setNewSecret(newSecret);
        return passportClient.changeSecret(changeSecret);
    }

    public PassportResponse validateSecret(String userId, String type, String secret) {
        ValidateSecret validateSecret = new ValidateSecret();
        validateSecret.setUserId(userId);
        validateSecret.setSecretType(type);
        validateSecret.setSecret(secret);
        return passportClient.validateSecret(validateSecret);
    }

    public PassportResponse addUserDocuments(String userId, String type, String path) {
        AddDocument addDocument = new AddDocument();
        addDocument.setType(type);
        addDocument.setPath(path);
        return passportClient.AddUserDocument(userId, addDocument);
    }
}
