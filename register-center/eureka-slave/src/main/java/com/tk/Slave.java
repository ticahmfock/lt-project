package com.tk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Slave {

	public static void main(String[] args) {
		SpringApplication.run(Slave.class, args);
	}

}
