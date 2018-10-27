package com.bobo.eurekacomsumer.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-23 18:47
 **/
public class HelloCommend extends HystrixCommand<String>{

    private RestTemplate restTemplate;

    public HelloCommend() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GroupName"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("CommandName"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ThreadPoolKey")));
    }
    public HelloCommend(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }
    @Override
    protected String run() throws Exception {
        String forObject = restTemplate.getForObject("http://EUREKA-CLIENT/hello", String.class);
        return forObject;
    }

    @Override
    protected String getFallback() {
        return "error";
    }

    @Override
    protected String getCacheKey() {
        return super.getCacheKey();
    }
}
