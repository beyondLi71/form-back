package com.bgy.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yyg
 * @date 2018/4/23 17:32
 * @desc 用户登录验证实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserPO {

    //主键
    private Long id;

    //用户名
    private String name;

    //密码
    private String pwd;
}
