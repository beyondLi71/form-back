package com.bgy.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yyg
 * @date 2018/4/25 10:49
 * @desc 系统用户角色关联实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserRolePO {

    //主键
    private Long id;

    //角色主键id
    private Long roleId;

    // 用户登录表主键id
    private Long userId;
}
