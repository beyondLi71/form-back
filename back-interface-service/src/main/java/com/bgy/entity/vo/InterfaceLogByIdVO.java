package com.bgy.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 11:56
 * @desc 日志入参及返回参数.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterfaceLogByIdVO {
    //方法名
    private String methodName;
    //接口地址
    private String infaceUrl;
    //入参
    private String request;
    //出参
    private  String response;
}

