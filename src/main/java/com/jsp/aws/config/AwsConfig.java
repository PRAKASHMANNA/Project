package com.jsp.aws.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@ConfigurationProperties(prefix="aws")
@Data
public class AwsConfig {
    private String accessKey;
    private String secretKey;
    private String region;
    private String s3BucketName;
    
    
    @Bean
    public S3Client s3client() {
    	AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);
        return S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();
    }
	/* #AWSBASICCREDENTIALS#
	 * AwsBasicCredentials- represents specifically, the access key ID and secret
	 * access key.
	 *  purpose - use it to create an object holding our AWS credentials
	 * in memory. This object will then be used to authenticate requests to AWS
	 * services (like S3). Internally, AwsBasicCredentials works like this: You give
	 * it your AWS Access Key and Secret Key.
	 * It holds these values.
	 * You pass it to StaticCredentialsProvider.
	 * S3Client uses that provider to authenticate your S3 API requests.
	 */
    
	/* #STATICCREDENTIALSPROVIDER#
	 * StaticCredentialsProvider- it is a credentials provider that provides static
	 * (fixed) credentials. Purpose: AWS SDK uses a credentials provider abstraction
	 * to supply credentials when making calls. StaticCredentialsProvider simply
	 * wraps your AwsBasicCredentials object so the SDK can use it.
	 */
	/* #REGION#
	 * region- purpose - it's specify the region, which region your S3 bucket
	 * is in so SDK knows where to send the request.
	 */
	/* #S3CLIENT#
	 * s3Client - This is the main AWS SDK client class for Amazon S3. it allows to
	 * interact with our java application-s3 bucket
	 */
}
