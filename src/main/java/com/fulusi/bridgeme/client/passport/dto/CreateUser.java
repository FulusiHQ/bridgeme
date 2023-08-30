package com.fulusi.bridgeme.client.passport.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateUser {

    @Pattern(regexp = "^(PIN|PASSWORD)$", message = "Allowed values for secret type are either PIN or PASSWORD")
    private String secretType;

    @NotNull(message = "secret cannot be null")
    private String secret;

    @NotNull(message = "userName cannot be null")
    private String userName;

    @NotNull(message = "firstName cannot be null")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    private String lastName;

    private String mobile;

    @Email(message = "email should be valid")
    private String email;


}
