package com.fulusi.bridgeme.client.passport;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fulusi.bridgeme.client.passport.dto.*;

@FeignClient(name = "PassportClient", url = "http://localhost:8000/")
public interface PassportClient {

    @RequestMapping(method = RequestMethod.POST, value = "/v1/users/create")
    PassportResponse createUser(@RequestBody CreateUser request);

    @RequestMapping(method = RequestMethod.PUT, value = "/v1/users/secret/update")
    PassportResponse updateSecret(@RequestBody UpdateSecret request);

    @RequestMapping(method = RequestMethod.PUT, value = "/v1/users/secret/change")
    PassportResponse changeSecret(@RequestBody ChangeSecret request);

    @RequestMapping(method = RequestMethod.POST, value = "/v1/users/secret/validate")
    PassportResponse validateSecret(@RequestBody ValidateSecret request);
   
    @RequestMapping(method = RequestMethod.POST, value = "/v1/documents/users/{userId}/add")
    PassportResponse AddUserDocument(@PathVariable("userId") String userId, @RequestBody AddDocument request);
}
