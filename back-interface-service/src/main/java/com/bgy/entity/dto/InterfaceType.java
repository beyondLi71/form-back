package com.bgy.entity.dto;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 10:14
 * @desc 接口类型
 */

public enum InterfaceType {
    WEBSERVICE("WEBSERVICE"),HTTP("HTTP");

    public String name;
    InterfaceType(String name) {
        this.name = name;
    }
}
