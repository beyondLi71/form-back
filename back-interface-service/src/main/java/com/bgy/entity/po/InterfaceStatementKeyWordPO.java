package com.bgy.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 13:05
 * @desc 接口日志报表关键字.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterfaceStatementKeyWordPO {
    //接口名
    private String interfaceName;
    //开始时间
    private LocalDateTime startTime;
    //结束时间
    private LocalDateTime endTime;
}

