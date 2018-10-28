package com.bobo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-28 8:59
 **/
@FeignClient(value = "eureka-client")
public interface HelloService {

    @RequestMapping(value = "hello")
    String Hello();
}
