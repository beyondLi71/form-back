package com.bgy.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author yyg
* @date 2018/4/25 10:49
* @desc  分配角色时回显实体VO
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "分配角色时回显实体")
public class AuthRoleEchoVO {

    //主键
    @ApiModelProperty(value = "主键", example = "")
    private Long id;

    //角色名称
    @ApiModelProperty(value = "角色名称", example = "")
    private String name;

}
