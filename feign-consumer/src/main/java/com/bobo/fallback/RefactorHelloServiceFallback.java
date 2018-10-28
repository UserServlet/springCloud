package com.bobo.fallback;

import com.bobo.bean.User;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-28 16:32
 **/
public class RefactorHelloServiceFallback implements com.bobo.service.api.HelloService {
    @Override
    public String Hello(String name) {
        return "bobo";
    }

    @Override
    public User Hello(String name, String age) {
        return new User("未知",0);
    }

    @Override
    public String Hello(User user) {
        return "hello"+"wuxiaobo"+", "+"bobo";
    }
}
