package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
* @author yyg
* @date 2018/4/26 11:12
* @desc  权限实体
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthFunctionDTO {

    @ApiModelProperty(value = "用户id", example = "")
    @NotNull(message = "IDEN_ERR_0009")
    private Long userId;

    @ApiModelProperty(value = "是否为根节点", example = "", hidden = true)
    private  String accordion;

}
