package com.bgy.service.impl;

import com.bgy.dao.HelloQueryMapper;
import com.bgy.service.HelloService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by beyondLi
 * Date 2018/4/21 15:18
 * Desc .
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Resource
    HelloQueryMapper helloQueryMapper;
    /**
     * 获取信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String getInfo() {
        String name = helloQueryMapper.getInfo();
        System.out.println(name);
        return name;
    }
}
