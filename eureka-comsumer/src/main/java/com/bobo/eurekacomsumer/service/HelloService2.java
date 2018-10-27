package com.bobo.eurekacomsumer.service;/**
 * Created by wuxiaobo on 2018/10/21.
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-21 10:59
 **/
@Service
public class HelloService2 {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    @CacheResult
    @HystrixCommand(fallbackMethod = "helloFeedback1",groupKey = "",threadPoolKey = "",commandKey = ""
                    )
    public String helloConsumer () {
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello",
                String.class).getBody();
    }

    @HystrixCommand(fallbackMethod = "helloFeedback")
    public String helloFeedback1() {
        return "Hello World";
    }


    public String helloFeedback() {
        return "error";
    }
}
