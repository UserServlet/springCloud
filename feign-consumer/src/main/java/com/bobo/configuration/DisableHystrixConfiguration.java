package com.bobo.configuration;

import feign.Feign;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2018-10-28 16:22
 **/
@Configurable
public class DisableHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder builder() {
        return Feign.builder();
    }
}
