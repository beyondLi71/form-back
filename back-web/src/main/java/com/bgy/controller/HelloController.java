package com.bgy.controller;

import com.bgy.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by beyondLi
 * Date 2018/4/21 15:13
 * Desc .
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @Resource
    HelloService helloService;
    @RequestMapping(value = "/get/info", method = RequestMethod.GET)
    public String getInfo(){
        String name = helloService.getInfo();
        return name;
    }
}
