package com.bgy.entity.dto;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 17:03
 * @desc 接口状态
 */

public enum InterfaceStatus {
    OPEN("开启"),CLOSE("关闭");

    public String name;
    InterfaceStatus(String name) {
        this.name = name;
    }
}
