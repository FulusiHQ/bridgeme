package com.fulusi.bridgeme.client.passport;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fulusi.bridgeme.client.passport.dto.CreateUser;
import com.fulusi.bridgeme.client.passport.dto.PassportResponse;

@FeignClient(name = "PassportClient", url = "http://localhost:8000/")
public interface PassportClient {


    @RequestMapping(method = RequestMethod.POST, value = "/v1/users/create")
    PassportResponse createUser(@RequestBody CreateUser request);
}
