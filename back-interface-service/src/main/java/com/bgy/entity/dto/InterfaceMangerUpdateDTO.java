package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 10:05
 * @desc 接口配置.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterfaceMangerUpdateDTO {
    @ApiModelProperty(value = "id", required = true, example = "10")
    @NotNull(message = "INTE_INFO_0000")
    private Integer id;
    @ApiModelProperty(value = "接口名", required = true, example = "admin")
    @NotNull(message = "INTE_INFO_0001")
    private String interfaceName;
    @ApiModelProperty(value = "方法名", required = true, example = "save")
    @NotNull(message = "INTE_INFO_0002")
    private String methodName;
    @ApiModelProperty(value = "访问类型", required = true, example = "HTTP")
    @NotNull(message = "INTE_INFO_0003")
    private InterfaceType type;
    @ApiModelProperty(value = "状态", required = true, example = "OPEN")
    @NotNull(message = "INTE_INFO_0004")
    private InterfaceStatus status;
    @ApiModelProperty(value = "当前用户", required = true, example = "admin")
    private String userId;
}

