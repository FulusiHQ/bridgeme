package com.fulusi.bridgeme.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignUp {
   
    @NotNull(message = "firstName cannot be null")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    private String lastName;

    @NotNull(message = "mobile cannot be null")
    private String mobile;

    @NotNull(message = "email cannot be null")
    private String email;

    @NotNull(message = "iD cannot be null")
    private String iD;

    @NotNull(message = "secret cannot be null")
    private String secret;

}
