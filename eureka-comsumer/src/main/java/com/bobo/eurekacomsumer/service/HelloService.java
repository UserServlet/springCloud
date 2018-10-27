package com.bobo.eurekacomsumer.service;
import com.bobo.eurekacomsumer.command.HelloCommend;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-21 10:59
 **/
@Service
public class HelloService {

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;


    /**
     * 同步调用
     * @return
     * @throws Exception
     */
    public String helloConsumer () throws Exception{
        com.netflix.hystrix.HystrixCommand.Setter setter = com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("bobo"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("group1"));
        String str = new HelloCommend(setter,restTemplate).execute();
        return str;
    }

    /**
     * 异步调用
     * @return
     * @throws Exception
     */
    public String helloConsumer2() throws Exception{
        Future<String> queue = new HelloCommend(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(new HystrixCommandGroupKey() {
            @Override
            public String name() {
                return "bobo";
            }
        }), restTemplate).queue();
        return queue.get();
    }


    /**
     * 异步调用
     * @return
     * @throws Exception
     */
    public String helloConsume3() throws Exception{
        Future<String> queue = new HelloCommend(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(new HystrixCommandGroupKey() {
            @Override
            public String name() {
                return "bobo";
            }
        }), restTemplate).queue();
        return queue.get();
    }



}
