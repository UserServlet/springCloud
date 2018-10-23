package com.bobo.eurekacomsumer.command;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-23 18:47
 **/
public class HelloCommend extends HystrixCommand<String>{

    private RestTemplate restTemplate;

    public HelloCommend(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }
    @Override
    protected String run() throws Exception {
        String forObject = restTemplate.getForObject("http://EUREKA-CLIENT/hello", String.class);
        return forObject;
    }

    @Override
    protected String getFallback() {
        return "error";
    }
}
