package com.bgy.entity.vo;

import com.bgy.entity.po.StatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 11:10
 * @desc 日志.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterfaceMangerDetailVO {
    //Id
    private String id;
    //接口名称
    private String interfaceName;
    //状态
    private StatusType status;
    //耗时
    private String time;
    //客户ip
    private String ip;
    //调用时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

}

