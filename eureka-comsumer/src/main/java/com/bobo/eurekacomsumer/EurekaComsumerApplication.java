package com.bobo.eurekacomsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuxiaobo@didachuxing.com
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaComsumerApplication {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return  new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(EurekaComsumerApplication.class, args);
    }
}
