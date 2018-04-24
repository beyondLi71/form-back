package com.bgy.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 11:01
 * @desc 日志子表.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterfaceMangerDetailPO {
    //Id
    private String id;
    //状态
    private StatusType status;
    //耗时
    private String time;
    //客户ip
    private String ip;
    //开始时间
    private LocalDateTime startTime;
    //接口名称
    private String interfaceName;


}

