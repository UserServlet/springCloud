package com.bobo.eurekaserver.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index() {
        ServiceInstance serviceInstance = client.getLocalServiceInstance();
        log.info(("/hello,host:")+serviceInstance.getHost()+",service_id:"+
                serviceInstance.getServiceId());
        return "hello world";
    }

}
