package com.bgy.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yyg
 * @date 2018/4/25 10:49
 * @desc 系统角色实体VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "角色根据userId回显数据和所有角色数据实体")
public class GetAuthUserRoleVO {

    @ApiModelProperty(value = "回显用户角色数据", example = "")
    private List<AuthRoleEchoVO> authRoleEchoVO;


    @ApiModelProperty(value = "所有角色数据", example = "")
    private List<AuthRoleVO> authRoleVO;
}
