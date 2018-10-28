package com.bobo.controller;

import com.bobo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.Oneway;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-28 9:02
 **/
@RestController
public class HelloController {


    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hello")
    public String Hello() {
        return helloService.Hello();
    }
}
