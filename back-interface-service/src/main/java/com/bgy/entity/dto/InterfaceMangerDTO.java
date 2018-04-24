package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 10:05
 * @desc 接口配置.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterfaceMangerDTO {
    @ApiModelProperty(value = "接口名", required = true, example = "admin")
    private String interfaceName;
    @ApiModelProperty(value = "方法名", required = true, example = "save")
    private String methodName;
    @ApiModelProperty(value = "访问类型", required = true, example = "HTTP")
    private InterfaceType type;
    @ApiModelProperty(value = "状态", required = true, example = "OPEN")
    private InterfaceStatus status;
}

