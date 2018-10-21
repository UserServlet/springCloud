package com.bobo.eurekacomsumer.controller;

import com.bobo.eurekacomsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者
 *
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-16 18:54
 **/
@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod. GET)
    public String helloConsumer () {
        return helloService.helloConsumer();
    }

}
