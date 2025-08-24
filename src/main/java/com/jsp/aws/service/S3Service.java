package com.jsp.aws.service;

import java.nio.file.Path;

import org.springframework.stereotype.Service;

import com.jsp.aws.config.AwsConfig;

import lombok.AllArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
@Service
@AllArgsConstructor
public class S3Service {
	private S3Client s3client;
	private AwsConfig awsConfig; //Holds our AWS access key, secret key, region, and bucket name (coming from application.properties).
     public String uploadFile(String keyName, Path filepath) {
			/*
			 * keyName - This is the file name (or path) that we want the file to have in s3.
			 * filePath - The path on our local machine where the file is located.
			 */
    	 PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                 .bucket(awsConfig.getS3BucketName())
                 .key(keyName)
                 .build();
			/*
			 * PutObjectRequest → This represents an upload request to S3. 
			 * .bucket() → Which bucket the file goes to. or Which bucket to upload to, means we create workQueue bucket
			 * .key() → What filename/path to use in S3.
			 */
    	 s3client.putObject(putObjectRequest, RequestBody.fromFile(filepath));
			/*
			 * s3client.putObject() → Uploads the file to Amazon S3.
			 * RequestBody.fromFile(filePath) → Wraps our file properly so AWS can process it.
			 */
    	 return keyName;
     }
  // Download file from S3
     public void downloadFileFromS3(String keyName, Path destinationPath) {
         s3client.getObject(GetObjectRequest.builder()
                 .bucket(awsConfig.getS3BucketName())
                 .key(keyName)
                 .build(), destinationPath);
     }
  // Check if file exists in S3
     public boolean doesFileExist(String keyName) {
         try {
             s3client.headObject(HeadObjectRequest.builder()
                     .bucket(awsConfig.getS3BucketName())
                     .key(keyName)
                     .build());
             return true;
         } catch (NoSuchKeyException e) {
             return false;
         }
     }
    
}
