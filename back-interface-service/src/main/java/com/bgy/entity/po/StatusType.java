package com.bgy.entity.po;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 16:24
 * @desc ${DESCRIPTION}.
 */

public enum StatusType {
    NORMAL("正常"),ERRO("异常");

    public String name;
    StatusType(String name) {
        this.name = name;
    }
}
