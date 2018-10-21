package com.bobo.eurekacomsumer.service;/**
 * Created by wuxiaobo on 2018/10/21.
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
public class HelloService {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFeedback")
    public String helloConsumer () {
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello",
                String.class).getBody();
    }

    public String helloFeedback() {
        return "error";
    }
}
