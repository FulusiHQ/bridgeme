package com.fulusi.bridgeme.service;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.fulusi.bridgeme.model.CloudFile;

@Service
public class FileService {

    private AmazonS3 s3Client;

    public FileService(String accessId, String secret, String url) {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessId, secret);

        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(
                url, "");
        s3Client = AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(endpointConfiguration)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

    public List<CloudFile> uploadFiles(String bucketName, List<MultipartFile> files) throws Exception {
        List<CloudFile> cloudFiles = new ArrayList<>();
        for (MultipartFile file : files) {
            cloudFiles.add(uploadFile(bucketName, file.getOriginalFilename(), UtilService.toFile(file)));
        }
        return cloudFiles;
    }

    public CloudFile uploadFile(String bucketName, String fileName, File file) {
        PutObjectResult result = s3Client.putObject(bucketName, fileName, file);
        return new CloudFile(fileName, result.getVersionId(), result.getETag());
    }

    public String generatePresignedUrl(String bucketName, String objectKey) {
        Date expiration = new Date(System.currentTimeMillis() + 3600000); // Set expiration time (1 hour from now)

        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey)
                .withMethod(HttpMethod.PUT)
                .withExpiration(expiration);

        URL presignedUrl = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
        return presignedUrl.toString();
    }

}
