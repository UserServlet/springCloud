package com.bobo.service;

import com.bobo.configuration.DisableHystrixConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-28 10:17
 **/


@FeignClient(value = "eureka-client",configuration = {DisableHystrixConfiguration.class})
public interface RefactorHelloService extends com.bobo.service.api.HelloService {
}
