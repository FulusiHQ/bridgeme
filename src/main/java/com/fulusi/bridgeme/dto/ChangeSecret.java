package com.fulusi.bridgeme.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class ChangeSecret {
   
    @NotNull(message = "userId cannot be null")
    private String userId;

    @Pattern(regexp = "^(pin|password)$", message = "Allowed values are either Pin or Password")
    private String secretType;

    @NotNull(message = "new secret cannot be null")
    private String newSecret;

    @NotNull(message = "new secret cannot be null")
    private String oldSecret;

}
