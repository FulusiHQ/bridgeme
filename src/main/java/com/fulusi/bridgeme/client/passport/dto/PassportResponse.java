package com.fulusi.bridgeme.client.passport.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fulusi.bridgeme.dto.BeResponse;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassportResponse extends BeResponse {
    private PassportUser user;
    private List<PassportUser> users;

    PassportResponse() {
    }
}
