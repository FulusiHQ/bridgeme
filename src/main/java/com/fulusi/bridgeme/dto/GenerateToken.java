package com.fulusi.bridgeme.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GenerateToken {

    @NotNull(message = "userName cannot be null")
    private String userName;

    @NotNull(message = "secret cannot be null")
    private String secret;

}
