package com.bobo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class GetewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetewayApiApplication.class, args);
	}
}
