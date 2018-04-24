package com.bgy.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author yyg
 * @date 2018/4/23 17:32
 * @desc 用户token历史记录实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserTokenLogPO {

    //主键
    private Long id;

    //用户id
    private Long userId;

    //token
    private String token;

    //token创建时间
    private LocalDateTime userCreateTime;

    //token失效时间
    private LocalDateTime userLoseTime;

    // 创建时间
    private LocalDateTime createTime;

    //创建人
    private Long createBy;

    //修改时间
    private LocalDateTime updateTime;

    //修改人
    private Long updateBy;


}
