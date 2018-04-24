package com.bgy.entity.dto;

import com.bgy.entity.po.StatusType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 10:24
 * @desc 接口日志查询条件.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterfaceLogKeyWordDTO {

    @ApiModelProperty(value = "接口名", required = true, example = "admin")
    private String interfaceName;
    @ApiModelProperty(value = "ip地址", required = true, example = "192.168.1.1")
    private String ip;
    @ApiModelProperty(value = "状态", required = true, example = "NORMAL")
    private StatusType status;
    @ApiModelProperty(value = "开始时间", required = true, example = "2018-04-24T08:51:07.827Z")
    private LocalDateTime startTime;
    @ApiModelProperty(value = "结束时间", required = true, example = "2018-04-24T08:51:07.827Z")
    private LocalDateTime endTime;


}

