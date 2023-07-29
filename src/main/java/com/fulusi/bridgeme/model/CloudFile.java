package com.fulusi.bridgeme.model;


import lombok.Data;

@Data
public class CloudFile {
    
    private String fileName;

    private String versionId;
    
    private String eTag;

    public CloudFile(String fileName, String versionId, String eTag) {
        this.fileName = fileName;
        this.versionId = versionId;
        this.eTag = eTag;
    }

}
