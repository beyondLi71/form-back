package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
* @author yyg
* @date 2018/4/26 11:12
* @desc  根据角色获取权限实体
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthFunctionForRoleDTO {

    @ApiModelProperty(value = "角色id", example = "")
    @NotNull(message = "IDEN_ERR_0016")
    private Long roleId;

    @ApiModelProperty(value = "是否为根节点", example = "", hidden = true)
    private  String accordion;

}
