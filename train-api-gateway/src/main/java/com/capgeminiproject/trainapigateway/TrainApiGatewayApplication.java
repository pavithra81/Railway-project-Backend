package com.capgeminiproject.trainapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableEurekaClient
public class TrainApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainApiGatewayApplication.class, args);
	}

}
