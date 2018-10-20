package com.bobo.eurekaserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类
 *
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-15 17:27
 **/
@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index() {
        String services = "ServiceUrl: " + discoveryClient.getLocalServiceInstance().getUri();
        System.err.println(services);
        return "hello world";
    }

}
