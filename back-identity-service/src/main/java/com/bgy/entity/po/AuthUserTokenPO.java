package com.bgy.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author yyg
 * @date 2018/4/23 17:32
 * @desc 用户登录使用token实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserTokenPO {

    //主键
    private Long id;

    //用户id
    private Long userId;

    //token
    private String token;

    //token创建时间
    private LocalDateTime userCreateTime;

    // 创建时间
    private LocalDateTime createTime;

    //创建人
    private String createBy;

    //修改时间
    private LocalDateTime updateTime;

    //修改人
    private String updateBy;
}
