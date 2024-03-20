package com.fulusi.bridgeme.client.passport.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddDocument {
   
    @NotNull(message = "type cannot be null")
    private String type;

    @NotNull(message = "path cannot be null")
    private String path;

    private String version = "1";

}
