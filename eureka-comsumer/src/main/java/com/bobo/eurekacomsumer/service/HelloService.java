package com.bobo.eurekacomsumer.service;
import com.bobo.eurekacomsumer.command.HelloCommend;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-21 10:59
 **/
@Service
public class HelloService {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFeedback")
    public String helloConsumer () throws Exception{
        String str = new HelloCommend(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(new HystrixCommandGroupKey() {
            @Override
            public String name() {
                return "bobo";
            }
        }),restTemplate).execute();
        return str;
    }

    public String helloFeedback() {
        return "error";
    }
}
