package com.bobo.service;

import com.bobo.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-28 8:59
 **/
@FeignClient(value = "eureka-client")
public interface HelloService {

    @RequestMapping(value = "hello")
    String Hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String Hello (@RequestParam String name);


    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User Hello (@RequestHeader String name, @RequestHeader String age);

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String Hello (@RequestBody User user);

}
