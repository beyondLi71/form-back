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
 * @desc 系统用户角色权限添加实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAuthRoleFunctionDTO {

    //角色主键id集合
    @ApiModelProperty(value = "菜单权限主键id集合", example = "")
    private List<Long> functionIds;

    //用户登录表主键id
    @ApiModelProperty(value = "角色表主键", example = "")
    @NotNull(message = "IDEN_ERR_0016")
    private Long roleId;
}
