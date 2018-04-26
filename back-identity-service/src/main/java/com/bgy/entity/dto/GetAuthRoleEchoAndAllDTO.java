package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
* @author yyg
* @date 2018/4/25 10:49
* @desc  分配角色时回显角色和全部角色实体DTO
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthRoleEchoAndAllDTO {

    //主键
    @ApiModelProperty(value = "当前登录人主键", example = "")
    @NotNull(message = "IDEN_ERR_0011")
    private Long userId;

    //角色名称
    @ApiModelProperty(value = "删除标记", example = "", hidden = true)
    private String isDelete;

}
