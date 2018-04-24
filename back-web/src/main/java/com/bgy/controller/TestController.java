package com.bgy.controller;

import com.bgy.common.dto.UserBaseInfoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @author yyg
* @date 2018/4/24 20:09
* @desc  获取当前登录用户信息
*/
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Resource
    UserBaseInfoDTO userBaseInfoDTO;


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getInfo() {
        String name = userBaseInfoDTO.getUserName();
        return name;
    }
}
