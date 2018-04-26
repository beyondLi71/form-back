package com.bgy.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yyg
 * @date 2018/4/23 17:32
 * @desc 用户登录验证实体VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthUserVO {

    //用户名
    private String name;

    //token

    private String token;

}
