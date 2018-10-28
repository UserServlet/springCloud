package com.bobo.service.api;

import com.bobo.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wuxiaobo@didachuxing.com
 * Created by wuxiaobo on 2018/10/28.
 */
@RequestMapping(value = "/refactor")
public interface HelloService {

    @RequestMapping(value = "/hello4",method = RequestMethod.GET)
    public String Hello (@RequestParam(value = "name") String name);


    @RequestMapping(value = "/hello5",method = RequestMethod.GET)
    public User Hello (@RequestHeader(value = "name") String name, @RequestHeader(value = "age") String age);

    @RequestMapping(value = "/hello6",method = RequestMethod.POST)
    public String Hello (@RequestBody User user);
}
