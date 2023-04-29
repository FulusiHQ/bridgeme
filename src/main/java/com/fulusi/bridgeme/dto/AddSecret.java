package com.fulusi.bridgeme.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddSecret {
   
    @NotNull(message = "userId cannot be null")
    private String userId;

    @Pattern(regexp = "^(pin|password)$", message = "Allowed values are either Pin or Password")
    private String secretType;

    @NotNull(message = "secret cannot be null")
    private String secret;
}
