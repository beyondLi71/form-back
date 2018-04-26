package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 20:10
 * @desc 白名单.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WiteListDTO {

    @ApiModelProperty(value = "id", required = true, example = "1")
    @NotNull(message = "WITE_INFO_0000")
    private Integer id;
    @ApiModelProperty(value = "url起始", required = true, example = "127.1.1.1")
    @NotNull(message = "WITE_INFO_0001")
    private String urlStart;
    @ApiModelProperty(value = "url结束", required = true, example = "127.1.1.128")
    @NotNull(message = "WITE_INFO_0002")
    private String urlEnd;
    @ApiModelProperty(value = "状态", required = true, example = "OPEN")
    @NotNull(message = "WITE_INFO_0003")
    private InterfaceStatus status;
    @ApiModelProperty(value = "备注", required = true, example = "aaaa")
    @NotNull(message = "WITE_INFO_0004")
    private String remark;
    @ApiModelProperty(value = "当前用户", required = true, example = "admin")
    private String userId;
}

