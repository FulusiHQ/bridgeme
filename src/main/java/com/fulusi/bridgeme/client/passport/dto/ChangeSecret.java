package com.fulusi.bridgeme.client.passport.dto;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ChangeSecret {
   
    @NotNull(message = "userId cannot be null")
    private String userId;

    @Pattern(regexp = "^(PIN|PASSWORD)$", message = "Allowed values are either PIN or PASSWORD")
    private String secretType;

    @NotNull(message = "new secret cannot be null")
    private String newSecret;

    @NotNull(message = "old secret cannot be null")
    private String oldSecret;

}
