package com.bobo.controller;

import com.bobo.bean.User;
import com.bobo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String Hello (@RequestParam String name){
        return helloService.Hello(name);
    }


    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User Hello (@RequestHeader String name, @RequestHeader String age) {
        return helloService.Hello(name,age);
    }

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String Hello (@RequestBody User user) {
        return helloService.Hello(user);
    }
}
