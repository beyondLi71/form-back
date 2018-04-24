package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
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
public class InterfaceStatementKeyWordDTO {
    @ApiModelProperty(value = "接口名", required = true, example = "admin")
    private String interfaceName;
    @ApiModelProperty(value = "开始时间", required = true, example = "2018-04-24T08:51:07.827Z")
    private LocalDateTime startTime;
    @ApiModelProperty(value = "结束时间", required = true, example = "2018-04-24T08:51:07.827Z")
    private LocalDateTime endTime;
}

