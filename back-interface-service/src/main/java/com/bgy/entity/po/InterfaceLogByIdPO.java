package com.bgy.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 12:55
 * @desc 日志出参入参.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterfaceLogByIdPO {
    //方法名
    private String methodName;
    //接口地址
    private String infaceUrl;
    //入参
    private String request;
    //出参
    private  String response;
}

