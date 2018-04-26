package com.bgy.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author yyg
* @date 2018/4/25 10:49
* @desc  系统角色权限关联查询实体
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRoleFunctionPO {

    //主键
    private Long id;

    //角色id
    private Long roleId;

    // 权限id
    private Long functionId;

}
