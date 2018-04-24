package com.bgy.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 11:19
 * @desc 日志搜索条件.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterfaceLogKeyWordPO {
    //接口名
    private String interfaceName;
    //ip地址
    private String ip;
    //状态
    private StatusType status;
    //开始时间
    private LocalDateTime startTime;
    //结束时间
    private LocalDateTime endTime;
}

