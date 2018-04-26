package com.bgy.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
* @author yyg
* @date 2018/4/26 11:12
* @desc  分配权限时回显数据，返回所有系统权限实体
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "分配权限时回显数据，返回所有系统权限实体")
public class AuthFunctionForUserAndAllVO {

    @ApiModelProperty(value = "回显数据", example = "")
    private List<AuthFunctionVO> userfucntions;

    @ApiModelProperty(value = "所有系统权限", example = "")
    private List<AuthFunctionVO> allFunctions;

}

