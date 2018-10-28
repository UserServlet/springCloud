package com.bobo.eurekaserver.controller;

import com.bobo.bean.User;
import com.bobo.service.api.HelloService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-28 10:13
 **/
@RestController
public class RefactorHelloController  implements HelloService{
    @Override
    public String Hello(String name) {
        return "Hello" +name;
    }

    @Override
    public User Hello(String name, String age) {
        return new User(name,Integer.parseInt(age));
    }

    @Override
    public String Hello(User user) {
        return "Hello" + user.getName() +", "+user.getAge();
    }
}
