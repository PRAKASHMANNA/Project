package com.jsp.aws;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.jsp.aws.config.AwsConfig;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigurationProperties(AwsConfig.class)
public class AmazonwebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonwebservicesApplication.class, args);
	}

}
