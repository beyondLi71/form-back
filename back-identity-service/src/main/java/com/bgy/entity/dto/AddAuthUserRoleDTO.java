package com.bgy.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author yyg
 * @date 2018/4/25 10:49
 * @desc 系统用户角色关联添加实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAuthUserRoleDTO {

    //角色主键id集合
    @ApiModelProperty(value = "角色主键id集合", example = "")
    private List<Long> roleIds;

    //用户登录表主键id
    @ApiModelProperty(value = "用户登录表主键id", example = "")
    @NotNull(message = "IDEN_ERR_0011")
    private Long userId;
}
